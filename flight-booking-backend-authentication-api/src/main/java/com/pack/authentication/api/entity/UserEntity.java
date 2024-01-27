package com.pack.authentication.api.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

//import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
//@Entity
//@Table(name = "users")
@Document(collection = "users")
public class UserEntity {

//    @Transient
//    public static final String SEQUENCE_NAME = "user_sequence";

    @Transient
    public static final String USER_SEQUENCE_NAME = "user_sequence";

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @MongoId
    private Integer userId;
    private String userFullName;
    private String userName;
    private String email;
    private String mobile;
    private String gender;
    private String dateOfBirth;
    private String password;
    private String roles;

    // ==========================================================================================


    private String resetPasswordToken;



}
