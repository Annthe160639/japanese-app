package com.prm.japaneseapp.model.entity;

import com.prm.japaneseapp.constant.StatusEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "radical")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RadicalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_order")
    private Integer numberOrder;

    @ManyToOne
    @JoinColumn(name = "radical_category_id")
    private RadicalCategoryEntity radicalCategory;

    private String radical;

    private String name;

    private String meaning;

    @Enumerated
    private StatusEnum status;
}
