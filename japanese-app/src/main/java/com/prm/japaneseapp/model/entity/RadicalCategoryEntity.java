package com.prm.japaneseapp.model.entity;

import com.prm.japaneseapp.constant.StatusEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "radical_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RadicalCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Enumerated
    private StatusEnum status;

}
