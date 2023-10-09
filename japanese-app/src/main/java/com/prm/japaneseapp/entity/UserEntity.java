package com.prm.japaneseapp.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "User")
@Entity
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String username;
    private String gmail;
    private String password;

}
