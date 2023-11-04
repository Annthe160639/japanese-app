package com.prm.japaneseapp.model.entity;

import com.prm.japaneseapp.constant.StatusEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "vocabulary")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private LessonEntity lesson;

    private String kanji;

    private String meaning;

    private String name;

    private String sound;

    private String example;

    @Enumerated
    private StatusEnum status;
}
