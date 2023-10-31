package com.prm.japaneseapp.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlphabetDto {
    private Integer id;

    private String hiragana;

    private String katakana;

    private String reading;

    private String sound;

    private String writingHiragana;

    private String writingKatakana;

    private Integer status;

}
