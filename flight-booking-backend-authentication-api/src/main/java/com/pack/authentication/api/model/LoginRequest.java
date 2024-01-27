package com.pack.authentication.api.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginRequest {

    private String userName;
    private String password;

}
