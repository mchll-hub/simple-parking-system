package com.enigma;

public class Vehicle {
    String registrationNumber;
    String colour;
    String type;

    public Vehicle(String registrationNumber, String colour, String type) {
        this.registrationNumber = registrationNumber;
        this.colour = colour;
        this.type = type;
    }

    public Vehicle() {
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOddPlate(){
        String[] parts = registrationNumber.split("-");
        int lastDigit = Integer.parseInt(parts[1].substring(parts[1].length() - 1));
        return lastDigit % 2 != 0;
    }
}
