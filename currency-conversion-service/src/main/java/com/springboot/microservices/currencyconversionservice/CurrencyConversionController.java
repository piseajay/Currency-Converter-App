package com.springboot.microservices.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    //talking to another microservice using Resttemplate
    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public ConvertedBean getConvertedValue(@PathVariable("from") String from,
                                           @PathVariable("to") String to,@PathVariable("quantity") BigDecimal quantity){

        Map<String,String> variables = new HashMap<>();
        variables.put("from",from);
        variables.put("to",to);

        ResponseEntity<ConvertedBean> entity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                ConvertedBean.class, variables);

        ConvertedBean response = entity.getBody();
        return new ConvertedBean(response.getId(),from,to, response.getConversionMultiple(),
                quantity.multiply(response.getConversionMultiple()),response.getPort());
    }

    //talking to another microservice using FeignClient
    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public ConvertedBean getFeignConvertedValue(@PathVariable("from") String from,
                                           @PathVariable("to") String to,@PathVariable("quantity") BigDecimal quantity){

        ConvertedBean feignResponse = proxy.getExchangedValue(from, to);

        return new ConvertedBean(feignResponse.getId(),from,to, feignResponse.getConversionMultiple(),
                quantity.multiply(feignResponse.getConversionMultiple()),feignResponse.getPort());

    }

}