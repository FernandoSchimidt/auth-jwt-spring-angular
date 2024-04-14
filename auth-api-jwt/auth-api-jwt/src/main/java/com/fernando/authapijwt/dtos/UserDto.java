package com.fernando.authapijwt.dtos;

import com.fernando.authapijwt.enums.RoleEnum;

public record UserDto(
        String name,
        String login,
        String password,
        RoleEnum role
) {
}
