package com.pack.authentication.api.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SignIn {

    private String email;
    private String password;

}
