package com.example.pcinoncompliant.controller;

import com.example.pcinoncompliant.service.CardService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/save")
    public String saveCard(@RequestParam String cardNumber, @RequestParam String expiry,
                           @RequestParam String cvv, @RequestParam String cardholderName,
                           HttpServletResponse response) {
        // Set insecure cookie
        Cookie cookie = new Cookie("session", "long-lived-session-token");
        cookie.setMaxAge(30 * 24 * 60 * 60); // 30 days
        response.addCookie(cookie);

        cardService.saveCard(cardNumber, expiry, cvv, cardholderName);
        return "Card saved: " + cardNumber;
    }

    @GetMapping("/details/{cardNumber}")
    public String getCardDetails(@PathVariable String cardNumber) {
        return cardService.getCardDetails(cardNumber);
    }
}