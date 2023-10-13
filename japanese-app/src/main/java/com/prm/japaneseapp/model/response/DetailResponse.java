package com.prm.japaneseapp.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DetailResponse<T> extends GeneralResponse<T> {
    private int page;

    private int size;

    private int totalPage;

    private Long totalItems;

    public DetailResponse(ResponseStatus status, T data, int page, int size, int totalPage, Long totalItems) {
        super(status, data);
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.totalItems = totalItems;
    }

}
