package com.fernando.authapijwt.controller;

import com.fernando.authapijwt.dtos.AuthDto;
import com.fernando.authapijwt.dtos.ResponseDTO;
import com.fernando.authapijwt.models.User;
import com.fernando.authapijwt.repositories.UserRepository;
import com.fernando.authapijwt.services.impl.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity auth(@RequestBody AuthDto authDto) {

        var userAuthenticationToken = new UsernamePasswordAuthenticationToken(authDto.login(), authDto.password());
        authenticationManager.authenticate(userAuthenticationToken);

        User user = userRepository.findByLogin(authDto.login());
        if (passwordEncoder.matches(authDto.password(), user.getPassword())) {
            String token = authenticationService.getToken(authDto);
            return ResponseEntity.ok(new ResponseDTO(user.getLogin(), user.getName(), token));
        }

        return ResponseEntity.badRequest().build();
    }
}
