package com.prm.japaneseapp.model.entity;

import com.prm.japaneseapp.constant.StatusEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "japanese_everyday")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JapaneseEverydayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    @Enumerated
    private StatusEnum status;
}
