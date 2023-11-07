package com.prm.japaneseapp.service.impl;

import com.mysql.cj.log.Log;
import com.prm.japaneseapp.constant.RoleEnum;
import com.prm.japaneseapp.constant.StatusEnum;
import com.prm.japaneseapp.dto.request.AccountRequestDto;
import com.prm.japaneseapp.dto.request.AccountUpdateRequestDto;
import com.prm.japaneseapp.dto.request.AuthRequestDto;
import com.prm.japaneseapp.dto.response.AccountResponseDto;
import com.prm.japaneseapp.dto.response.LoginResponseDto;
import com.prm.japaneseapp.mapper.AccountMapper;
import com.prm.japaneseapp.model.entity.AccountEntity;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    // To convert String to Date
    public static LocalDate getDateFromString(String string, DateTimeFormatter format) {
        // Converting the string to date
        // in the specified format
        LocalDate date = LocalDate.parse(string, format);

        // Returning the converted date
        return date;
    }

    public ResponseEntity<Object> login(AuthRequestDto authRequest) {
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
        AccountEntity account = this.getObjRepository().findAccountEntityByMail(authRequest.getMail());
        final String jwt = jwtUtil.generateTokenFromAuthentication(authentication);

        //set dob using SimpleDateFormat
//        String pattern = "yyyy-MM-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
//        String strDate = simpleDateFormat.format(account.getDob());
//        Date date;
//        try {
//            date = simpleDateFormat.parse(strDate);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        account.setDob(date);

        //set dob using DateTimeFormatter: https://www.geeksforgeeks.org/java-program-to-convert-string-to-date/
        //get the dob string
        String strDob = account.getDob().toString();
        // Getting the format by creating an object of DateTImeFormatter class, example: 2023-10-18 00:00:00.0
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        LocalDate localDate = getDateFromString(strDob, format);
        log.info("dob = " + localDate);

        Date DOB = java.sql.Date.valueOf(localDate);
        account.setDob(DOB);

        LoginResponseDto responseDto = LoginResponseDto.builder()
                .token(jwt)
                .id(account.getId())
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .mail(account.getMail())
                .avatar(account.getAvatar())
                .dob(account.getDob())
                .phone(account.getPhone())
                .build();

        return this.getResponseFactory().success(responseDto, LoginResponseDto.class);
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
                .role(RoleEnum.STUDENT)
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

    @Override
    @Transactional
    public ResponseEntity<Object> update(AccountUpdateRequestDto account) {
        AccountEntity currentAccount = this.getObjRepository().findAccountEntityById(account.getId());
        if (currentAccount == null) {
            log.debug("Account không tồn tại");
            return this.getResponseFactory().failBusiness(ResponseStatusCode.NOT_FOUND,
                    "Account không tồn tại");
        }

        currentAccount.setLastName(account.getLastName());
        currentAccount.setFirstName(account.getFirstName());
        currentAccount.setPhone(account.getPhone());
        currentAccount.setDob(account.getDob());
        currentAccount.setAvatar(account.getAvatar());
        AccountEntity result = this.getObjRepository().update(currentAccount);

        if (result != null) {
            //Update successful
            log.info("Update successfully");
            return this.getResponseFactory().success(this.getObjMapper().entityToDto(result), AccountResponseDto.class);
        }
        //Update failed
        log.error("Update failed");
        return this.getResponseFactory().failBusiness(ResponseStatusCode.INTERNAL_SERVER, "Vui lòng thử lại sau");
    }
}
