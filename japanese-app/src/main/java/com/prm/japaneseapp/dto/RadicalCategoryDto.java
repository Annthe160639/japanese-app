package com.prm.japaneseapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RadicalCategoryDto {
    private Long id;

    private String name;

    private Integer status;
}
