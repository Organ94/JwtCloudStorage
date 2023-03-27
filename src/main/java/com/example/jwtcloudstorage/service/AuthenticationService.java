package com.example.jwtcloudstorage.service;

import com.example.jwtcloudstorage.jwt.JwtTokenProvider;
import com.example.jwtcloudstorage.repository.AuthenticationRepository;
import com.example.jwtcloudstorage.dto.response.AuthenticationRS;
import com.example.jwtcloudstorage.dto.request.AuthenticationRQ;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AuthenticationService {

    private AuthenticationRepository authenticationRepository;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private UserService userService;

    public AuthenticationRS login(AuthenticationRQ authenticationRQ) {
        final String username = authenticationRQ.getUsername();
        final String password = authenticationRQ.getPassword();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        final UserDetails userDetails = userService.loadUserByUsername(username);
        final String token = jwtTokenProvider.generateToken(userDetails);
        authenticationRepository.putTokenAndUsername(token, username);
        log.info("User {} authentication. JWT: {}", username, token);
        return new AuthenticationRS(token);
    }
}
