package com.pack.authentication.api.business;


import com.pack.authentication.api.dao.MainRepository;
import com.pack.authentication.api.entity.UserEntity;
import com.pack.authentication.api.exception.UserNotFoundException;
import com.pack.authentication.api.model.SignIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class MainService {

    @Autowired
    private MainRepository mainRepository;

    public String signIn(String email, String password) {
        return null;
    }

    public UserEntity signUp(String fullName, String userName, String email, String mobile, String gender, String dateOfBirth, String password, String roles) {
        return null;
    }

    public UserEntity findEmailByEmail(String email) {
        return mainRepository.findEmailByEmail(email);
    }

    public UserEntity findMobileByMobile(String mobile) {
        return mainRepository.findMobileByMobile(mobile);
    }

    public UserEntity findUserByEmailAndPassword(String email, String password) {
        return mainRepository.findUserByEmailAndPassword(email, password);
    }

    public UserEntity findUserByEmailAndMobile(String email, String mobile) {
        return mainRepository.findUserByEmailAndMobile(email, mobile);
    }

    public UserEntity registerUser(UserEntity user) {
        return mainRepository.save(user);
    }

    public String getFormattedDate(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String getDate = dateFormat.format(date);
        return getDate;
    }

    public String dateConverter(String dob) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        String newDob = null;
        date = inputFormat.parse(dob);
        newDob = outputFormat.format(date);
        System.out.println(newDob);
        return newDob;
    }


}
