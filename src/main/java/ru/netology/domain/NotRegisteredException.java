package ru.netology.domain;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Один из игроков не зарегистрирован");
    }
}

