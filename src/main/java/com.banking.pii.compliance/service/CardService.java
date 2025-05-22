package com.example.pcinoncompliant.service;

import com.example.pcinoncompliant.entity.Card;
import com.example.pcinoncompliant.repository.CardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    private static final Logger logger = LoggerFactory.getLogger(CardService.class);
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void saveCard(String cardNumber, String expiry, String cvv, String cardholderName) {
        logger.info("Saving card: {}, CVV: {}, Name: {}", cardNumber, cvv, cardholderName);
        Card card = new Card();
        card.setCardNumber(cardNumber);
        card.setExpiry(expiry);
        card.setCvv(cvv);
        card.setCardholderName(cardholderName);
        cardRepository.save(card);
    }

    public String getCardDetails(String cardNumber) {
        Card card = cardRepository.findByCardNumber(cardNumber);
        return "Card: " + card.getCardNumber() + ", Expiry: " + card.getExpiry() + ", CVV: " + card.getCvv();
    }
}