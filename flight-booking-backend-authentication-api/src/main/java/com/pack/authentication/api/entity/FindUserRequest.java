package com.pack.authentication.api.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FindUserRequest {

    private String userName;
    private String email;
    private String mobile;

}
