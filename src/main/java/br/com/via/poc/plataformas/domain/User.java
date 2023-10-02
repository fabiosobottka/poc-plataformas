package br.com.via.poc.plataformas.domain;

public class User {

    private final String name;

    private final Long registrationNumber;

    public User(String name, Long registrationNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public Long getRegistrationNumber() {
        return registrationNumber;
    }
}
