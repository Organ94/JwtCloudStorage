package com.example.jwtcloudstorage.controller;

import com.example.jwtcloudstorage.dto.request.AuthenticationRQ;
import com.example.jwtcloudstorage.dto.response.AuthenticationRS;
import com.example.jwtcloudstorage.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public AuthenticationRS login(@RequestBody AuthenticationRQ authenticationRQ) {
        return authenticationService.login(authenticationRQ);
    }
}
