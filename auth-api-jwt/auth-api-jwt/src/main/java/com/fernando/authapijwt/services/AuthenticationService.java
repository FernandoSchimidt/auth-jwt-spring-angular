package com.fernando.authapijwt.services;

import com.fernando.authapijwt.dtos.AuthDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService extends UserDetailsService {

    public String getToken(AuthDto authDto);
    public String validateTokenJwt(String token);
}
