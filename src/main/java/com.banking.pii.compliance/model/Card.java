package com.example.pcinoncompliant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Card {
    @Id
    private String cardNumber;
    private String expiry;
    private String cvv;
    private String cardholderName;

    // Getters and setters
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public String getExpiry() { return expiry; }
    public void setExpiry(String expiry) { this.expiry = expiry; }
    public String getCvv() { return cvv; }
    public void setCvv(String cvv) { this.cvv = cvv; }
    public String getCardholderName() { return cardholderName; }
    public void setCardholderName(String cardholderName) { this.cardholderName = cardholderName; }
}