package com.pack.authentication.api.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class JwtAuthenticationRequestAsUserName {

    private String userName;
    private String password;

}
