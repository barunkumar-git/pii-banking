package com.example.pcinoncompliant.repository;

import com.example.pcinoncompliant.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card, String> {
    @Query("SELECT c FROM Card c WHERE c.cardNumber = ?1")
    Card findByCardNumber(String cardNumber);
}