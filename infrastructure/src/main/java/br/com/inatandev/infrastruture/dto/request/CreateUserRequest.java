package br.com.inatandev.infrastruture.dto.request;

import br.com.inatandev.core.domain.enums.UserTypeEnum;

public record CreateUserRequest(String email, String password, String taxNumber, String fullname, UserTypeEnum type, String pin) {
}
