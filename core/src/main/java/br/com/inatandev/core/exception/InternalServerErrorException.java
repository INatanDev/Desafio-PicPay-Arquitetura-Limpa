package br.com.inatandev.core.exception;

public class InternalServerErrorException extends Exception {
    public InternalServerErrorException(String message, String code) {
        super(message);
    }
}
