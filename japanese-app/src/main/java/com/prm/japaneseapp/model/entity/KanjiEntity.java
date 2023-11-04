package com.prm.japaneseapp.model.entity;

import com.prm.japaneseapp.constant.StatusEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "kanji")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KanjiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private LessonEntity lesson;

    private String reading;

    private String writing;

    private String meaning;

    private String kunyomi;

    private String onyomi;

    private String example;

    @Enumerated
    private StatusEnum status;
}
