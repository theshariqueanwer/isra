package com.pack.authentication.api.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class JwtAuthenticationResponseAsUserName {

    private String token;

}
