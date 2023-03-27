package com.example.jwtcloudstorage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationRQ {

    private String username;
    private String password;
}
