package com.lzcalderaro.registrationClient.entities;

public final class Client {

    private final String name;
    private final String email;
    private final String identityNumber;
    private final String mobileNumber;
    private Integer id;

    public Client(String name, String email, String identityNumber, String mobileNumber) {
        this.name = name;
        this.email = email;
        this.identityNumber = identityNumber;
        this.mobileNumber = mobileNumber;
    }

    public Client(int id, String name, String email, String identityNumber, String mobileNumber) {
        this.id = id;
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

    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getIdentityNumber() {return identityNumber;}
    public String getMobileNumber() {return mobileNumber;}
    public Integer getId() {return id;}
}
