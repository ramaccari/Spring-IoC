package com.main.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class ShoppingCarService {

    private List<String> products = new ArrayList<>();

    private Integer counter = 0;

    @PostConstruct
    public void postConstruct() {
        System.out.println("====> Creada instancia de " + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("====> Destruyendo instancia de " + this.getClass().getSimpleName());
    }

    public void add() {
        products.add("Micrófono-" + ++counter);
    }

    public List<String> get() {
        return products;
    }
}
