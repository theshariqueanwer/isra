package com.pack.authentication.api.controller;


import com.pack.authentication.api.entity.UserEntity;
import com.pack.authentication.api.exception.UserNotFoundException;
import com.pack.authentication.api.model.EmailRequest;
import com.pack.authentication.api.repository.UserRepository;
import com.pack.authentication.api.send.EmailSenderService;
import com.pack.authentication.api.service.UserService;
import com.pack.authentication.api.utility.Utility;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Pair;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class ForgotPasswordResetController {

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/forgot_password")
    public String processForgotPassword(@RequestBody EmailRequest emailRequest, HttpServletRequest request) {

        String email = emailRequest.getEmail();
        System.out.println(email);

        String token  = RandomStringUtils.randomAlphabetic(50);
        System.out.println(token);

        try {
            userService.saveResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
            System.out.println(resetPasswordLink);
            sendEmail(email, resetPasswordLink);

        } catch (UserNotFoundException ex) {
            ex.getMessage();
        }
        catch (UnsupportedEncodingException | MessagingException e) {
            e.getMessage();
        }

        return "we have successfully sent an email to you email id," + "\n\r" +
                "please check your email and reset the password";
        // return "forgot_password_form";
    }


//    @GetMapping("/reset_password")
//    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
//        UserEntity user = userService.findByResetPasswordToken(token);
//        model.addAttribute("token", token);
//
//        if (user == null) {
//            model.addAttribute("message", "Invalid Token");
//            return "message";
//        }
//        return "reset_password_form";
//    }


//    @PostMapping("/reset_password")
//    public String processResetPassword(HttpServletRequest request, Model model) {
//
//        String token = request.getParameter("token");
//        String password = request.getParameter("password");
//
//        UserEntity user = userService.findByResetPasswordToken(token);
//        model.addAttribute("title", "Reset your password");
//
//        if (user == null) {
//            model.addAttribute("message", "Invalid Token");
//            return "message";
//        } else {
//            userService.updatePassword(user, password);
//            model.addAttribute("message", "You have successfully changed your password.");
//        }
//        return "message";
//    }

    public void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("hannahsra012@gmail.com", "Sra Support");
        helper.setTo(recipientEmail);

        String subject = "Here's the link to reset your password";

        UserEntity user = userRepository.findByEmail(recipientEmail);
        String name = user.getUserFullName();

        String content = "<p>Hello, "  + name +  "</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\"> change my password </a></p>"
                + "<br>"
                + "<p>ignore this email if you do remember your password, "
                + "or you have not made the request. </p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        javaMailSender.send(message);
    }


}
