package com.example.demo.email;

public interface EmailSender {
    default void send(String to, String email) {

    }
}
