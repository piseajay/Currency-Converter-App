package com.springboot.microservices.currencyexchangeservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class ExchangeBean {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    @Column(name="Conversion_multiple")
    private BigDecimal conversionMultiple;
    @Column
    private Integer port;

    public ExchangeBean() {
    }

    public ExchangeBean(Integer id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
