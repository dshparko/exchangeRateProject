package by.dshparko.exchangerateproject.model;

import lombok.Data;

import java.util.Map;

@Data
public class ExchangeResponse {
    private Map<String, Double> rates;
}

