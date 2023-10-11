package com.prm.japaneseapp.entity;

import com.prm.japaneseapp.constant.RoleEnum;
import com.prm.japaneseapp.constant.StatusEnum;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Length(max = 100)
    private String mail;

    @Column(name = "last_name")
    @NotBlank
    @Length(max = 50)
    private String lastName;

    @Column(name = "first_name")
    @NotBlank
    @Length(max = 50)
    private String firstName;

    @NotBlank
    @Length(min = 8, max = 100)
    private String password;

    @NotBlank
    @Length(max = 12)
    private String phone;

    @NotNull
    private Date dob;

    @NotBlank
    @Length(max = 100)
    private String avatar;

    @Enumerated
    private RoleEnum role;

    @Enumerated
    private StatusEnum status;
}
