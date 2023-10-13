package com.prm.japaneseapp.controller;

import com.prm.japaneseapp.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController<S extends BaseService> {

    @Autowired
    private S objService;

    public S getObjService() {
        return this.objService;
    }
}
