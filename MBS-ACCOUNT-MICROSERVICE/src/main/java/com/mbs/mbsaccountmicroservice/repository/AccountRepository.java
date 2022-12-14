package com.mbs.mbsaccountmicroservice.repository;

import com.mbs.mbsaccountmicroservice.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
    Account findOneByNumberAndPin(String number, String pin);
    Account findOneByNumber(String number);
    Account findOneByName(String name);

}
