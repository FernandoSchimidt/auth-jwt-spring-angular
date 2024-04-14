package com.fernando.authapijwt.services.impl;

import com.fernando.authapijwt.dtos.UserDto;
import com.fernando.authapijwt.models.User;
import com.fernando.authapijwt.repositories.UserRepository;
import com.fernando.authapijwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto save(UserDto userDto) {

        User ifUserExists = userRepository.findByLogin(userDto.login());
        if (ifUserExists != null) throw new RuntimeException("User already exists!");
        var passwordHash = passwordEncoder.encode(userDto.password());
        User user = new User(userDto.name(), userDto.login(), passwordHash, userDto.role());
        User newUser = userRepository.save(user);
        return new UserDto(newUser.getName(), newUser.getLogin(), newUser.getPassword(), newUser.getRole());
    }
}
