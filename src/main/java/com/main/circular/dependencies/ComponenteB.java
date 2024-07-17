package com.main.circular.dependencies;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponenteB {

    @Autowired
    private ComponenteC componenteC;

    @PostConstruct
    public void postConstruct() {
        System.out.println("====> Creada instancia de " + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("====> Destruyendo instancia de " + this.getClass().getSimpleName());
    }

}

