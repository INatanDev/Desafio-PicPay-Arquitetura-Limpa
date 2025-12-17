package br.com.inatandev.infrastruture.dto.response;

import java.util.List;

public record ErrorResponse(String code, String message, List<ValidationError> validations) {}
