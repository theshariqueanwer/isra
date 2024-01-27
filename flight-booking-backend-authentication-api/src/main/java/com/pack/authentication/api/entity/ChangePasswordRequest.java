package com.pack.authentication.api.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ChangePasswordRequest {

    private String userName;
    private String email;
    private String mobile;
    private String password;

}
