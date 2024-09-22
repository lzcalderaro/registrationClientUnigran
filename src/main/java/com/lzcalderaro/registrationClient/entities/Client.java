package com.lzcalderaro.registrationClient.entities;

public final class Client {

    private final String name;
    private final String email;
    private final String identityNumber;
    private final String mobileNumber;

    public Client(String name, String email, String identityNumber, String mobileNumber) {
        this.name = name;
        this.email = email;
        this.identityNumber = identityNumber;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + System.lineSeparator() +
                "Email: " + email + System.lineSeparator() +
                "Identity Number: " + identityNumber + System.lineSeparator() +
                "Mobile Number: " + mobileNumber + System.lineSeparator();
    }
}
