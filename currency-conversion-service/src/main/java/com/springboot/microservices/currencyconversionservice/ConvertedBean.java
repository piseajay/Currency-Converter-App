package com.springboot.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class ConvertedBean {

    private Integer id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal totalAmount;
    private Integer port;

    public ConvertedBean() {
    }

    public ConvertedBean(Integer id, String from, String to, BigDecimal conversionMultiple, BigDecimal totalAmount, Integer port) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.totalAmount = totalAmount;
        this.port = port;
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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
