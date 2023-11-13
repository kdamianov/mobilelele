package org.softuni.mobilele.service.impl;

import org.junit.jupiter.api.Test;
import org.softuni.mobilele.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest // вдига се целият app context
class CurrencyServiceImplTestIntegrTest {

    @Autowired // injecting the real CurrencyService
    private CurrencyService currencyServiceToTest;

    //TODO
}