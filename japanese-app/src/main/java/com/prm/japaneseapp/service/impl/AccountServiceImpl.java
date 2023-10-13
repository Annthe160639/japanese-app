package com.prm.japaneseapp.service.impl;

import com.prm.japaneseapp.config.security.jwt.JwtUtil;
import com.prm.japaneseapp.dto.response.AccountResponseDTO;
import com.prm.japaneseapp.model.entity.AccountEntity;
import com.prm.japaneseapp.mapper.AccountMapper;
import com.prm.japaneseapp.model.request.AccountRequestDto;
import com.prm.japaneseapp.model.request.AuthRequest;
import com.prm.japaneseapp.model.response.GeneralResponse;
import com.prm.japaneseapp.model.response.ResponseStatus;
import com.prm.japaneseapp.model.response.ResponseStatusCode;
import com.prm.japaneseapp.repository.AccountRepository;
import com.prm.japaneseapp.service.AccountService;
import com.prm.japaneseapp.config.security.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AuthenticationManager authenticationManager;
    private final AccountMapper accountMapper;
    private final JwtUtil jwtUtil;

    @Override
    public GeneralResponse<Object> getAllAccount() {
        List<AccountResponseDTO> accountResponseDTOS = accountRepository.findAll().stream()
                .map(accountMapper::entityToDto)
                .toList();
        return GeneralResponse.builder()
                .status(new ResponseStatus(ResponseStatusCode.SUCCESS))
                .data(accountResponseDTOS)
                .build();
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

        return ResponseEntity.ok(jwt);
    }

    @Override
    public void register(AccountRequestDto account) {
        //Not implement yet
    }
}
