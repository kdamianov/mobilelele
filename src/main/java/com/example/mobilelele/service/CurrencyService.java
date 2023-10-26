package com.example.mobilelele.service;

import com.example.mobilelele.model.dto.ExchangeRatesDTO;

public interface CurrencyService {
    void refreshRates(ExchangeRatesDTO exchangeRatesDTO);
}
