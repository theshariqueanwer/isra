package com.pack.authentication.api.serviceimplementation;


import com.pack.authentication.api.entity.ChangePasswordRequest;
import com.pack.authentication.api.entity.FindUserRequest;
import com.pack.authentication.api.entity.UserEntity;
import com.pack.authentication.api.exception.UserNotFoundException;
import com.pack.authentication.api.model.LoginRequest;
import com.pack.authentication.api.repository.UserRepository;
import com.pack.authentication.api.service.SequenceNumberGeneratorService;
import com.pack.authentication.api.service.UserSequenceNumberGeneratorService;
import com.pack.authentication.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSequenceNumberGeneratorService userSequenceNumberGeneratorService;

    @Override
    public UserEntity registerUser(UserEntity user) {
        // sequence generator
        user.setUserId(userSequenceNumberGeneratorService.getUserSequenceNumber(UserEntity.USER_SEQUENCE_NAME));
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//
//        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public UserEntity findUserByUserNameAndPassword(LoginRequest request) {

        // validation

        // verify user exist with given UserName and Password
        UserEntity user = userRepository.findOneByUserNameAndPassword(request.getUserName(),request.getPassword());

        // response
        return user;
    }

    // ==========================================================================================


    @Override
    public UserEntity findByEmail(String email) throws UserNotFoundException {
        UserEntity user = userRepository.findByEmail(email);

        if (user != null )
        {
            return user;
        }
        else {
            throw new UserNotFoundException("could not find any customer with the this email id : " + email);
        }
    }

    @Override
    public void saveResetPasswordToken(String token, String email) throws UserNotFoundException {
        UserEntity user = userRepository.findByEmail(email);

        if (user != null) {
            user.setResetPasswordToken(token);
            userRepository.save(user);
        } else {
            throw new UserNotFoundException("could not find any customer with the this email id : " + email);
        }
    }

    @Override
    public UserEntity findByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }

    @Override
    public void updatePassword(UserEntity user, String newPassword) {
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //String encodedPassword = passwordEncoder.encode(newPassword);

        //user.setPassword(encodedPassword);
        user.setPassword(newPassword);
        user.setResetPasswordToken(null);
        userRepository.save(user);
    }


    // ===============================================================================================

    @Override
    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findUserById(Integer userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public UserEntity findUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    @Override
    public UserEntity findUserByUserFullName(String userFullName) {
        return userRepository.findUserByUserFullName(userFullName);
    }

    @Override
    public UserEntity updateUserById(Integer userId, UserEntity user) {
        UserEntity user1 = findUserById(userId);
        user.setUserId(user1.getUserId());
        user.setUserFullName(user1.getUserFullName());
        user.setUserName(user1.getUserName());
        user.setEmail(user1.getEmail());
        user.setMobile(user1.getMobile());
        user.setGender(user1.getGender());
        user.setDateOfBirth(user1.getDateOfBirth());
        user.setPassword(user1.getPassword());
        user.setRoles(user1.getRoles());
        return userRepository.save(user);
    }

    @Override
    public UserEntity updateUserByUser(UserEntity user) {
        user.setUserId(user.getUserId());
        user.setUserFullName(user.getUserFullName());
        user.setUserName(user.getUserName());
        user.setEmail(user.getEmail());
        user.setMobile(user.getMobile());
        user.setGender(user.getGender());
        user.setDateOfBirth(user.getDateOfBirth());
        user.setPassword(user.getPassword());
        user.setRoles(user.getRoles());
        return userRepository.save(user);
    }

    @Override
    public UserEntity deleteUserById(Integer userId) {
        UserEntity user = userRepository.findById(userId).get();
        userRepository.deleteById(userId);
        return user;
    }

    @Override
    public List<UserEntity> deleteAllUser() {
        List<UserEntity> users = userRepository.findAll();
        userRepository.deleteAll();
        return users;
    }

    @Override
    public UserEntity changePassword(ChangePasswordRequest changePasswordRequest) throws UserNotFoundException {
        UserEntity user = userRepository.findUserByUserNameAndEmailAndMobile(new FindUserRequest(changePasswordRequest.getUserName(),changePasswordRequest.getEmail(),changePasswordRequest.getMobile()));
        if (user != null) {
            user.setPassword(changePasswordRequest.getPassword());
            userRepository.save(user);
        } else {
            // throw new UserNotFoundException( "could not find any user with userName " + changePasswordRequest.getUserName()) + "and email " + changePasswordRequest.getEmail() + "and mobile " + changePasswordRequest.getMobile());
            throw new UserNotFoundException("no user found ");
        }
        return user;
    }

    @Override
    public UserEntity findUserByUserNameAndEmailAndMobile(FindUserRequest findUserRequest) {
        return userRepository.findUserByUserNameAndEmailAndMobile(findUserRequest);
    }
}
