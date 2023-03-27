package com.example.jwtcloudstorage.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AuthenticationRepository {

    private final Map<String, String> tokenAndUsername = new ConcurrentHashMap<>();

    public void putTokenAndUsername(String token, String username) {
        tokenAndUsername.put(token, username);
    }

    public void removeTokenAndUsernameByToken(String token) {
        tokenAndUsername.remove(token);
    }

    public String getUsernameByToken(String token) {
        return tokenAndUsername.get(token);
    }
}
