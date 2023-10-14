package com.prm.japaneseapp.service.impl;


import com.prm.japaneseapp.mapper.BaseMapper;
import com.prm.japaneseapp.model.response.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<E, D, R extends JpaRepository<?, ?>, M
        extends BaseMapper<E, D>> extends WebApiCommon<R> {

    @Autowired
    private M objectMapper;
    private ResponseFactory factory;

    @Autowired
    public M getObjMapper() {
        return this.objectMapper;
    }
}
