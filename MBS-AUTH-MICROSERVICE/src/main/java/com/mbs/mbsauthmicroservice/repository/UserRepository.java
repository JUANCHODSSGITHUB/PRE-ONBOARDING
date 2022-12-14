package com.mbs.mbsauthmicroservice.repository;

import com.mbs.mbsauthmicroservice.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findOneByEmail(String email);
}
