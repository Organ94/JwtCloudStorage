package com.example.jwtcloudstorage.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationRS {

//    @JsonProperty("auth-token")
    private String token;
}
