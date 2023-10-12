package com.prm.japaneseapp.repository.custom.impl;

import com.prm.japaneseapp.model.entity.AccountEntity;
import com.prm.japaneseapp.repository.custom.CustomAccountRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


public class CustomAccountRepositoryImpl implements CustomAccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<AccountEntity> findAll() {
        TypedQuery<AccountEntity> query = entityManager.createQuery("SELECT t FROM AccountEntity t", AccountEntity.class);
        return query.getResultList();
    }
}
