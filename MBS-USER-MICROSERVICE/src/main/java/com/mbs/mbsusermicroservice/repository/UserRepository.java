package com.mbs.mbsusermicroservice.repository;

import com.mbs.mbsusermicroservice.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {

    Optional<User> findOneByEmail(String email);
    Optional<User> findOneByPhone(String phone);
}
