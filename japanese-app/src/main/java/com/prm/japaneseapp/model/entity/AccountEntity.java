package com.prm.japaneseapp.model.entity;

import com.prm.japaneseapp.constant.RoleEnum;
import com.prm.japaneseapp.constant.StatusEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    private String mail;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    private String password;

    private String phone;

    private Date dob;

    private String avatar;

    @Enumerated
    private RoleEnum role;

    @Enumerated
    private StatusEnum status;
}
