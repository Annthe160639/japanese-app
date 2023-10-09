package com.prm.japaneseapp.service;

import com.prm.japaneseapp.common.exception.CustomException;
import com.prm.japaneseapp.entity.UserEntity;
import com.prm.japaneseapp.model.AuthRequest;
import com.prm.japaneseapp.repository.UserRepository;
import com.prm.japaneseapp.util.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private CustomUserDetailsService userDetailsService;
    private JwtTokenProvider jwtUtil;

    public UserService(UserRepository userRepository, AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService, JwtTokenProvider jwtUtil) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public void register(UserEntity user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }

    public ResponseEntity<?> login (AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.error("Sai tên người dùng hoặc mật khẩu");
            throw new BadCredentialsException("Sai tên người dùng hoặc mật khẩu", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(jwt);
    }
}
