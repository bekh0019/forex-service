package com.bekh.springboot.microservice.example.forex.springbootmicroserviceforexservice.controller;

import com.bekh.springboot.microservice.example.forex.springbootmicroserviceforexservice.entity.ExchangeValue;
import com.bekh.springboot.microservice.example.forex.springbootmicroserviceforexservice.repository.ExchangeValueRepository;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class ForexController {

    private final Environment environment;

    private final ExchangeValueRepository repository;

    public ForexController(Environment environment, ExchangeValueRepository repository) {
        this.environment = environment;
        this.repository = repository;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue
            (@PathVariable String from, @PathVariable String to){

        ExchangeValue exchangeValue =
                repository.findByFromAndTo(from, to);

        exchangeValue.setPort(
                Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));

        return exchangeValue;
    }
}
