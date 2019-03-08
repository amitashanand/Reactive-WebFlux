package com.wiredbraincofee.productapiannotation;

import com.wiredbraincofee.productapiannotation.Model.Product;
import com.wiredbraincofee.productapiannotation.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ProductApiAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApiAnnotationApplication.class, args);
	}
	@Bean
	CommandLineRunner init(ProductRepository repository){
		return args -> {
			Flux<Product> productsFlux= Flux.just(
					new Product(null,"Big Latte",2.99),
					new Product(null,"Big Deaf",2.49),
					new Product(null,"Green Tea",1.99)
			).flatMap(p->repository.save(p));

			productsFlux.thenMany(repository.findAll())
					.subscribe(System.out::println);
		};
	}
}


