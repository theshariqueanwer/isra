package com.pack.authentication.api.dao;

import com.pack.authentication.api.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MainRepository extends MongoRepository<UserEntity, Integer> {

    public UserEntity findUserByEmailAndPassword(String email, String password);

    public UserEntity findEmailByEmail(String email);

    public UserEntity findMobileByMobile(String mobile);

    public UserEntity findUserByEmailAndMobile(String email, String mobile);

}
