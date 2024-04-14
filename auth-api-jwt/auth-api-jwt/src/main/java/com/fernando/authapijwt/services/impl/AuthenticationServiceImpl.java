package com.fernando.authapijwt.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fernando.authapijwt.dtos.AuthDto;
import com.fernando.authapijwt.models.User;
import com.fernando.authapijwt.repositories.UserRepository;
import com.fernando.authapijwt.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login);
    }

    @Override
    public String getToken(AuthDto authDto) {
        User user = userRepository.findByLogin(authDto.login());
        return generateTokeJwt(user);
    }

    public String generateTokeJwt(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret-api");
            return JWT.create()
                    .withIssuer("auth-api-jwt")
                    .withSubject(user.getLogin())
                    .withExpiresAt(generateExpirationToken())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro to generate token: " + e.getMessage());
        }
    }

    private Instant generateExpirationToken() {
        return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
    }

    public String validateTokenJwt(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret-api");

            return JWT.require(algorithm)
                    .withIssuer("auth-api-jwt")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException e) {
            return "";
        }
    }
}
