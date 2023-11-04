package com.prm.japaneseapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularyDto {

    private Integer id;

    private LessonDto lesson;

    private String kanji;

    private String meaning;

    private String name;

    private String sound;

    private String example;

    private Integer status;
}
