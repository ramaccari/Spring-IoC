package com.main.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryB implements ProductRepository {

    @PostConstruct
    public void postConstruct() {
        System.out.println("====> Creada instancia de " + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("====> Destruyendo instancia de " + this.getClass().getSimpleName());
    }

    @Override
    public void save(String name) {
        System.out.println("== SAVE " + this.getClass().getSimpleName() + " ==");
        System.out.println("Producto guardado exitosamente: " + name);
    }

    @Override
    public void remove(String name) {
        System.out.println("== REMOVE " + this.getClass().getSimpleName() + " ==");
        System.out.println("Producto eliminado exitosamente: " + name);
    }

}
