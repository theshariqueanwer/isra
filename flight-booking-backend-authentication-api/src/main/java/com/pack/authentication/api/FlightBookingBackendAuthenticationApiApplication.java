package com.pack.authentication.api;

import com.pack.authentication.api.send.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.web.firewall.*;

import javax.mail.MessagingException;

@SpringBootApplication
public class FlightBookingBackendAuthenticationApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(FlightBookingBackendAuthenticationApiApplication.class, args);
	}

}
