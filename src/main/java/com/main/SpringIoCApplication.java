package com.main;

import com.main.service.ProductService;
import com.main.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringIoCApplication {

	@Value("${messages.success}")
	private String message;

	@Autowired
	ProductService productService;

	@Autowired
	ShoppingCarService shoppingCarService;

	public static void main(String[] args) {
		SpringApplication.run(SpringIoCApplication.class, args);
	}

	@Bean
	public CommandLineRunner comandoUtilizandoAutowired() {
		return args -> {
			productService.save("Teclado RGB");
			productService.remuve("Auriculares Básicos");
		};
	}

	@RequestMapping("/example")
	public String example() {
		productService.save("Zapatos Nike");
		return "Hello desde Spring Boot!";
	}

	@RequestMapping("/get-message")
	public String getExample() {
		return message;
	}

	@RequestMapping("/add-product")
	public String addProduct() {
		shoppingCarService.add();
		return "Producto agregado";
	}

	@RequestMapping("/get-products")
	public List<String> getProducts() {
		return shoppingCarService.get();
	}

}
