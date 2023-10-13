package com.prm.japaneseapp.service.impl;

import com.prm.japaneseapp.model.response.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("java:S2326")
public abstract class WebApiCommon<R extends JpaRepository<?, ?>> {
    @Autowired
    private R objRepository;

    @Autowired
    private ResponseFactory responseFactory;

    public R getObjRepository() {
        return this.objRepository;
    }

    public ResponseFactory getResponseFactory() {
        return this.responseFactory;
    }
}
