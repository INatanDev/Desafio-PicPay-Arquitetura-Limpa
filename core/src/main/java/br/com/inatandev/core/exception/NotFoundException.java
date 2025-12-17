package br.com.inatandev.core.exception;

public class NotFoundException extends Exception {
    public NotFoundException(String message, String code) {
        super(message);
    }
}
