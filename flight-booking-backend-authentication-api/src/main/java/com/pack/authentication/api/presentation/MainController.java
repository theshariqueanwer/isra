package com.pack.authentication.api.presentation;


import com.pack.authentication.api.business.MainService;
import com.pack.authentication.api.entity.UserEntity;
import com.pack.authentication.api.exception.UserNotFoundException;
import com.pack.authentication.api.model.SignIn;
import com.pack.authentication.api.service.UserSequenceNumberGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @Autowired
    private UserSequenceNumberGeneratorService userSequenceNumberGeneratorService;


    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/register")
    public String register() {
        return "sign_up";
    }

    @GetMapping("/login")
    public String login() {
        return "sign_in";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @PostMapping("/sign_up")
    public @ResponseBody String signUp(HttpServletRequest request, Model model, ModelAndView modelAndView) throws ParseException {
        String fullName = request.getParameter("fullName");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String code = request.getParameter("code");
        String gender = request.getParameter("gender");
        String dateOfBirth = request.getParameter("dateOfBirth");
//        String address = request.getParameter("address");
//        String city = request.getParameter("city");
//        String state = request.getParameter("state");
//        String pinCode = request.getParameter("pinCode");
//        String country = request.getParameter("country");
        String password = request.getParameter("password");
        String roles = request.getParameter("roles");
        dateOfBirth.getClass().getSimpleName();
        dateOfBirth = mainService.dateConverter(dateOfBirth);
        mobile = code + "-" + mobile;

        UserEntity user = new UserEntity();
        UserEntity user1 = mainService.findEmailByEmail(email);
        UserEntity user2 = mainService.findMobileByMobile(mobile);
        UserEntity user3 = mainService.findUserByEmailAndMobile(email, mobile);

        if (user1 != null) {
            model.addAttribute("message", "user already exits with this emil id " + user1.getEmail() );
            return "error";
        } else if (user2 != null) {
            model.addAttribute("message", "user already exits with this emil id " + user2.getMobile());
            return "error";
        } else if ( user3 != null) {
        model.addAttribute("message", "user already exits with this emil id " + user3.getEmail() + "and mobile " + user3.getMobile());
        return "error";
        } else {
            // sequence generator
            user.setUserId(userSequenceNumberGeneratorService.getUserSequenceNumber(UserEntity.USER_SEQUENCE_NAME));
            user.setUserFullName(fullName);
            user.setUserName(userName);
            user.setEmail(email);
            user.setMobile(mobile);
            user.setGender(gender);
            user.setDateOfBirth(dateOfBirth);
            user.setPassword(password);
            user.setRoles(roles);
            mainService.registerUser(user);
            model.addAttribute("message", "You have successfully registered.");
        }
        return "welcome";
    }

    @PostMapping("/sign_in")
    public @ResponseBody String signIn(HttpServletRequest request) throws UserNotFoundException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserEntity user = mainService.findUserByEmailAndPassword(email, password);
        if( user != null ) {
            return "welcome";
        } else {
            return "could not find any user with this email id : " + email;
        }
    }

    @GetMapping("/findEmailByEmail/{email}")
    public @ResponseBody UserEntity findEmailByEmail(@PathVariable("email") String email) {
        return mainService.findEmailByEmail(email);
    }

    @GetMapping("/findMobileByMobile/{mobile}")
    public @ResponseBody UserEntity findMobileByMobile(@PathVariable("mobile") String mobile) {
        return mainService.findMobileByMobile(mobile);
    }


}
