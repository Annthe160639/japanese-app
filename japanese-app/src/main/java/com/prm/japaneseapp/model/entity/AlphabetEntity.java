package com.prm.japaneseapp.model.entity;

import com.prm.japaneseapp.constant.StatusEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "alphabet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlphabetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String hiragana;

    private String katakana;

    private String reading;

    private String sound;

    @Column(name = "writing_hiragana")
    private String writingHiragana;

    @Column(name = "writing_katakana")
    private String writingKatakana;

    @Enumerated
    private StatusEnum status;
}
