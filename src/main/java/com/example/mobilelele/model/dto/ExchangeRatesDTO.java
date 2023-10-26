package com.example.mobilelele.model.dto;

import java.math.BigDecimal;
import java.util.Map;

public record ExchangeRatesDTO(String BaseCurrency,
                               Map<String, BigDecimal> rate) {

}
