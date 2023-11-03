package com.prm.japaneseapp.service.impl;

import com.prm.japaneseapp.constant.RoleEnum;
import com.prm.japaneseapp.constant.StatusEnum;
import com.prm.japaneseapp.dto.response.AccountResponseDto;
import com.prm.japaneseapp.mapper.AccountMapper;
import com.prm.japaneseapp.model.entity.AccountEntity;
import com.prm.japaneseapp.model.request.AccountRequestDto;
import com.prm.japaneseapp.model.request.AuthRequest;
import com.prm.japaneseapp.model.response.ResponseStatusCode;
import com.prm.japaneseapp.repository.AccountRepository;
import com.prm.japaneseapp.security.jwt.JwtUtil;
import com.prm.japaneseapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl
        extends BaseService<AccountEntity, AccountResponseDto, AccountRepository, AccountMapper>
        implements AccountService {
    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
            return this.getResponseFactory().failBusiness(ResponseStatusCode.UNAUTHORIZED,
                    "Sai tên người dùng hoặc mật khẩu");
        }
        final String jwt = jwtUtil.generateTokenFromAuthentication(authentication);

        return this.getResponseFactory().success(jwt, String.class);
    }

    @Override
    @Transactional
    public ResponseEntity<Object> register(AccountRequestDto account) {
        if (this.getObjRepository().findAccountEntityByMail(account.getMail()) != null) {
            log.debug("Email đã tồn tại");
            return this.getResponseFactory().failBusiness(ResponseStatusCode.REGISTER_FAILED,
                    "Email đã tồn tại");
        }
        AccountEntity result = this.getObjRepository().persist(AccountEntity.builder()
                .mail(account.getMail())
                .password(passwordEncoder.encode(account.getPassword()))
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .dob(account.getDob())
                .phone(account.getPhone())
                .role(RoleEnum.STUDENT)
                .avatar(account.getAvatar())
                .status(StatusEnum.ENABLE)
                .build());

        if (result != null) {
            //Regiser successful
            log.info("Register successfully");
            return this.getResponseFactory().success(this.getObjMapper().entityToDto(result), AccountResponseDto.class);
        }
        //Register failed
        log.error("Register failed");
        return this.getResponseFactory().failBusiness(ResponseStatusCode.INTERNAL_SERVER, "Vui lòng thử lại sau");
    }
}
