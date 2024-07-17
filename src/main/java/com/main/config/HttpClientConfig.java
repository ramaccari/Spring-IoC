package com.main.config;

import com.main.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfig {

    @Bean
    public RestTemplate restTemplate(@Qualifier("productRepositoryB") ProductRepository productRepository) {
        System.out.println("Creando un RestTemplate");
        productRepository.save("T-SHIRT XL");
        return new RestTemplate();
    }

}
