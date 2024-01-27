package com.pack.authentication.api.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserEntityRequest {

    private Integer userId;
    private String userFullName;
    private String userName;
    private String email;
    private String mobile;

}
