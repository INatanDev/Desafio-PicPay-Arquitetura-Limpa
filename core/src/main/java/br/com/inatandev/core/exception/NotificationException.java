package br.com.inatandev.core.exception;

public class NotificationException extends Exception {
    public NotificationException(String message, String code) {
        super(message);
    }
}
