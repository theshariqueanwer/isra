package com.pack.authentication.api.controller;


import com.pack.authentication.api.entity.ChangePasswordRequest;
import com.pack.authentication.api.entity.FindUserRequest;
import com.pack.authentication.api.entity.UserEntity;
import com.pack.authentication.api.exception.UserNotFoundException;
import com.pack.authentication.api.model.JwtAuthenticationRequestAsUserName;
import com.pack.authentication.api.model.LoginRequest;
import com.pack.authentication.api.service.SecureUserDetailsService;
import com.pack.authentication.api.service.UserService;
import com.pack.authentication.api.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecureUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

//    @GetMapping("/home")
//    public String home() {
//        return "welcome to home";
//    }
//
//    @GetMapping("/welcome")
//    public String welcome() {
//        return "welcome to our resources";
//    }

    @PostMapping("/registerUser")
    public UserEntity registerUser(@RequestBody UserEntity user) {
        System.out.println(user);
        return userService.registerUser(user);
    }

    @PostMapping("/loginUserByUserName")
    public UserEntity findUserByUserNameAndPassword(@RequestBody LoginRequest request) {
        return userService.findUserByUserNameAndPassword(request);
    }

    @PostMapping("/changePassword")
    public UserEntity changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) throws UserNotFoundException {
        return userService.changePassword(changePasswordRequest);
    }

    @PostMapping("/findUserByUserNameAndEmailAndMobile")
    public UserEntity findUserByUserNameAndEmailAndMobile(@RequestBody FindUserRequest findUserRequest) {
        return userService.findUserByUserNameAndEmailAndMobile(findUserRequest);
    }

    // =========================================================================================

    @GetMapping("/findByEmail/{email}")
    public UserEntity findByEmail(@PathVariable ("email") String email ) throws UserNotFoundException {
        return userService.findByEmail(email);
    }

    // =========================================================================================

    @GetMapping("/findAllUser")
    public List<UserEntity> findAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/findUserById/{id}")
    public UserEntity findUserById(@PathVariable ("id") Integer userId) {
        return userService.findUserById(userId);
    }

    @GetMapping("/findUserByUserName/{userName}")
    public UserEntity findUserByUserName(@PathVariable ("userName") String userName) {
        return userService.findUserByUserName(userName);
    }

    @GetMapping("/findUserByUserFullName/{userFullName}")
    public UserEntity findUserByUserFullName(@PathVariable ("userFullName") String userFullName) {
        return userService.findUserByUserFullName(userFullName);
    }

    @PutMapping("/updateUserById/{id}")
    public UserEntity updateUserById(@PathVariable ("id") Integer userId, @RequestBody UserEntity user) {
        return userService.updateUserById(userId, user);
    }

    @PutMapping("/updateUserByUser")
    public UserEntity updateUserByUser(@RequestBody UserEntity user) {
        return userService.updateUserByUser(user);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public UserEntity deleteUserById(@PathVariable ("id") Integer userId) {
        return userService.deleteUserById(userId);
    }

    @DeleteMapping("/deleteAllUser")
    public List<UserEntity> deleteAllUser() {
        return userService.deleteAllUser();
    }


    // ==========================================================================================
    // ==================================== json web token ======================================

    @RequestMapping(value = "/loginWithUserName", method = RequestMethod.POST)
    public String getJwtToken(@RequestBody JwtAuthenticationRequestAsUserName authenticationRequestAsUserName) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequestAsUserName.getUserName(),
                    authenticationRequestAsUserName.getPassword()
            ));
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            throw new Exception("bad credential, username and password ar incorrect " + e);
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(
                authenticationRequestAsUserName.getUserName()
        );
        final String jwtToken = jwtTokenUtil.generateToken(userDetails);
        return jwtToken;
    }

}
