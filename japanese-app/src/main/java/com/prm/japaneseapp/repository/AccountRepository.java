package com.prm.japaneseapp.repository;

import com.prm.japaneseapp.model.entity.AccountEntity;
import com.prm.japaneseapp.repository.custom.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseRepository<AccountEntity, Long> {
    AccountEntity findAccountEntityByMail(String mail);
}
