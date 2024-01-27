package com.pack.authentication.api.repository;


import com.pack.authentication.api.entity.FindUserRequest;
import com.pack.authentication.api.entity.UserEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, Integer> {

    public Optional<UserEntity> findByUserName(String username);

    public UserEntity findOneByUserNameAndPassword(String userName, String password);

    // ===========================================================================================

    public UserEntity findByEmail(String email);

    //@Query("SELECT USER FROM USERS user WHERE user.email = ?1")
    //public UserEntity findByEmail(String email);

    public UserEntity findByResetPasswordToken(String token);

    // ===========================================================================================

    public UserEntity findUserByUserName(String userName);

    public UserEntity findUserByUserFullName(String userFullName);


    public UserEntity findUserByUserNameAndEmailAndMobile(FindUserRequest findUserRequest);

}
