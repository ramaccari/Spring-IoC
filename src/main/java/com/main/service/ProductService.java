package com.main.service;

import com.main.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
public class ProductService {

    @Value("${messages.success}")
    private String message;

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void postConstruct() {
        System.out.println("====> Creada instancia de " + this.getClass().getSimpleName());
        System.out.println("====> Message con @Value: " + message);
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("====> Destruyendo instancia de " + this.getClass().getSimpleName());
    }

    public void save(String name) {
        productRepository.save(name);
    }

    public void remuve(String name) {
        productRepository.remove(name);
    }

}
