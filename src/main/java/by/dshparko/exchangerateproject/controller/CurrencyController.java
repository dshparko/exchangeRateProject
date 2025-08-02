package by.dshparko.exchangerateproject.controller;

import by.dshparko.exchangerateproject.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/{code}")
    public ResponseEntity<String> getGif(@PathVariable String code) {
        String gifUrl = currencyService.getGifByCurrency(code.toUpperCase());
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(gifUrl)).build();
    }
}

