package com.bekh.springboot.microservice.example.forex.springbootmicroserviceforexservice.repository;

import com.bekh.springboot.microservice.example.forex.springbootmicroserviceforexservice.entity.ExchangeValue;
import org.springframework.data.repository.CrudRepository;

public interface ExchangeValueRepository extends CrudRepository<ExchangeValue, Long> {

    ExchangeValue findByFromAndTo(String from, String to);
}
