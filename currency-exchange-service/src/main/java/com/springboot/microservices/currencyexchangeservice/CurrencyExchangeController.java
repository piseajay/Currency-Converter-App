package com.springboot.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeBean getExchangedValue(@PathVariable("from") String from,
                                          @PathVariable("to") String to){

        ExchangeBean exchangeBean = exchangeValueRepository.findByFromAndTo(from, to);

        exchangeBean.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeBean;
    }
}
