package com.prm.japaneseapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RadicalDto {

    private Long id;

    private Integer numberOrder;

    private String radical;

    private String name;

    private String meaning;

    private Integer status;

}
