package com.prm.japaneseapp.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KanjiDto {

    private Integer id;

    private LessonDto lesson;

    private String reading;

    private String writing;

    private String meaning;

    private String kunyomi;

    private String onyomi;

    private String example;

    private Integer status;
}
