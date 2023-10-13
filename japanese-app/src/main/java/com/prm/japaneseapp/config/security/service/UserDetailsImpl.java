package com.prm.japaneseapp.config.security.service;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prm.japaneseapp.model.entity.AccountEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1;
    private Collection<? extends GrantedAuthority> authorities;
    private Long id;
    private String mail;
    @JsonIgnore
    private String password;

    public UserDetailsImpl(Long id, String mail, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(AccountEntity user) {

        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(
                user.getRole().name())
        );

        return new UserDetailsImpl(
                user.getId(),
                user.getMail(),
                user.getPassword(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
