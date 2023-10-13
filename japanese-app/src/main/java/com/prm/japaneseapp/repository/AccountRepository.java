package com.prm.japaneseapp.repository;

import com.prm.japaneseapp.model.entity.AccountEntity;
import com.prm.japaneseapp.repository.custom.CustomAccountRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseRepository<AccountEntity, Long>, CustomAccountRepository {
    AccountEntity findAccountEntityByMail(String mail);
}
