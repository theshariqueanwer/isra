package com.pack.authentication.api.service;


import com.pack.authentication.api.entity.ChangePasswordRequest;
import com.pack.authentication.api.entity.FindUserRequest;
import com.pack.authentication.api.entity.UserEntity;
import com.pack.authentication.api.exception.UserNotFoundException;
import com.pack.authentication.api.model.LoginRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public UserEntity registerUser(UserEntity user);

    public UserEntity findUserByUserNameAndPassword(LoginRequest request);

    // =================================================================================================

    public UserEntity findByEmail(String email) throws UserNotFoundException;

    public void saveResetPasswordToken(String token, String email) throws UserNotFoundException;

    public UserEntity findByResetPasswordToken(String token);

    public void updatePassword(UserEntity user, String newPassword);


    // =================================================================================================

    public List<UserEntity> findAllUser();

    public UserEntity findUserById(Integer userId);

    public UserEntity findUserByUserName(String userName);

    public UserEntity findUserByUserFullName(String userFullName);

    public UserEntity updateUserById(Integer userId, UserEntity user);

    public UserEntity updateUserByUser(UserEntity user);

    public UserEntity deleteUserById(Integer userId);

    public List<UserEntity> deleteAllUser();


    public UserEntity changePassword(ChangePasswordRequest changePasswordRequest) throws UserNotFoundException;

    public UserEntity findUserByUserNameAndEmailAndMobile(FindUserRequest findUserRequest);

}
