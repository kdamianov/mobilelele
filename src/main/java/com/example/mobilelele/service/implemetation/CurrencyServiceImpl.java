package com.example.mobilelele.service.implemetation;

import com.example.mobilelele.model.dto.ExchangeRatesDTO;
import com.example.mobilelele.service.CurrencyService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Override
    public void refreshRates(ExchangeRatesDTO exchangeRatesDTO) {
        BigDecimal BGN_TO_USD = getExchangeRate(exchangeRatesDTO, "BGN", "USD").orElse(null);
        BigDecimal BGN_TO_EUR = getExchangeRate(exchangeRatesDTO, "BGN", "EUR").orElse(null);
    }

    private static Optional<BigDecimal> getExchangeRate(
            ExchangeRatesDTO exchangeRatesDTO,
            String fromCurrency,
            String toCurrency
    ) {
        //e.g. USD -> USD
        if (Objects.equals(fromCurrency, toCurrency)) {
            return Optional.of(BigDecimal.ONE);
        }

        // e.g. USD -> BGN
        if (fromCurrency.equals(exchangeRatesDTO.BaseCurrency())) {
            if (exchangeRatesDTO.rate().containsKey(toCurrency)) {
                return Optional.of(exchangeRatesDTO.rate().get(toCurrency));
            }
        } else if (Objects.equals(toCurrency, exchangeRatesDTO.BaseCurrency())) {
            //BGN -> USD
            if (exchangeRatesDTO.rate().containsKey(fromCurrency)) {
                return Optional.of(BigDecimal.ONE.divide(
                        exchangeRatesDTO.rate().get(fromCurrency),
                        3,
                        RoundingMode.DOWN
                ));
            }
        } else if (exchangeRatesDTO.rate().containsKey(fromCurrency) &&
                exchangeRatesDTO.rate().containsKey(toCurrency)) {
            return Optional.of(
                    exchangeRatesDTO.rate().get(toCurrency)
                            .divide(exchangeRatesDTO.rate().get(fromCurrency),
                                    3,
                                    RoundingMode.DOWN)
            );

        }
        return Optional.empty();
    }
}
