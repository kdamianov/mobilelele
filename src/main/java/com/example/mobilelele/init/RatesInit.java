package com.example.mobilelele.init;

import com.example.mobilelele.config.OpenExchangeRatesConfig;
import com.example.mobilelele.model.dto.ExchangeRatesDTO;
import com.example.mobilelele.service.CurrencyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class RatesInit implements CommandLineRunner {

    private final OpenExchangeRatesConfig openExchangeRatesConfig;
    private final RestTemplate restTemplate;
    private final CurrencyService currencyService;

    public RatesInit(OpenExchangeRatesConfig openExchangeRatesConfig,
                     RestTemplate restTemplate, CurrencyService currencyService) {
        this.openExchangeRatesConfig = openExchangeRatesConfig;
        this.restTemplate = restTemplate;
        this.currencyService = currencyService;
    }


    @Override
    public void run(String... args) throws Exception {
        String openExchangeRatesURLTemplate =
                openExchangeRatesConfig.getSchema() +
                        "://" +
                        openExchangeRatesConfig.getHost() +
                        openExchangeRatesConfig.getPath() +
                        "?app_id={app_id}&symbols={symbols}";


        Map<String, String> requestParams = Map.of(
                "app_id", openExchangeRatesConfig.getAppId(),
                "symbols", String.join(",", openExchangeRatesConfig.getSymbols())
        );

        ExchangeRatesDTO exchangeRatesDTO = restTemplate.getForObject(
                openExchangeRatesURLTemplate,
                ExchangeRatesDTO.class,
                requestParams);

        //TODO register at https://openexchangerates.org

        currencyService.refreshRates(exchangeRatesDTO);
    }
}
