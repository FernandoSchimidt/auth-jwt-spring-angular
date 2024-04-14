package com.fernando.authapijwt.dtos;

import com.fernando.authapijwt.enums.RoleEnum;

public record ResponseDTO(String login, String name, String token) {
}