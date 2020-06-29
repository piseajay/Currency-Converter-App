package com.springboot.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeBean,Integer> {

    ExchangeBean findByFromAndTo(String from,String to);
}
