package com.springboot.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service",url = "http://localhost:8000")--load balancing hardcoding
@FeignClient(name = "currency-exchange-service") //load balancing using ribbon
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ConvertedBean getExchangedValue(@PathVariable("from") String from,@PathVariable("to") String to);

}
