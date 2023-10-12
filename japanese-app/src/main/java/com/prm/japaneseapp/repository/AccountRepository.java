package com.prm.japaneseapp.repository;

import com.prm.japaneseapp.model.entity.AccountEntity;
import com.prm.japaneseapp.repository.custom.CustomAccountRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long>, CustomAccountRepository {
    AccountEntity findAccountEntityByMail(String mail);
}
