package com.prm.japaneseapp.service.impl;

import com.prm.japaneseapp.dto.response.AccountResponseDto;
import com.prm.japaneseapp.security.jwt.JwtUtil;
import com.prm.japaneseapp.mapper.AccountMapper;
import com.prm.japaneseapp.model.entity.AccountEntity;
import com.prm.japaneseapp.model.request.AccountRequestDto;
import com.prm.japaneseapp.model.request.AuthRequest;
import com.prm.japaneseapp.repository.AccountRepository;
import com.prm.japaneseapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl
        extends BaseService<AccountEntity, AccountResponseDto, AccountRepository, AccountMapper>
        implements AccountService {
    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    @Override
    public ResponseEntity<Object> getAllAccount() {
        List<AccountResponseDto> accountResponseDTOS = this.getObjRepository().findAll().stream()
                .map(this.getObjMapper()::entityToDto)
                .toList();
        return this.getResponseFactory().success(accountResponseDTOS, Object.class);
    }

    public ResponseEntity<Object> login(AuthRequest authRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getMail(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.error("Sai tên người dùng hoặc mật khẩu");
            throw new BadCredentialsException("Sai tên người dùng hoặc mật khẩu", e);
        }
        final String jwt = jwtUtil.generateTokenFromAuthentication(authentication);

        return this.getResponseFactory().success(jwt, String.class);
    }

    @Override
    public void register(AccountRequestDto account) {
        //Not implement yet
    }
}
