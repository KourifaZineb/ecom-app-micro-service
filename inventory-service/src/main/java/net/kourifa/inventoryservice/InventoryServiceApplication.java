package net.kourifa.inventoryservice;

import net.kourifa.inventoryservice.entities.Product;
import net.kourifa.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.price(35000)
					.name("PC GAMER")
					.quantity(20)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.price(10000)
					.name("Iphone 16")
					.quantity(10)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.price(2900)
					.name("Huawei P90")
					.quantity(15)
					.build());

			productRepository.findAll().forEach(product -> {
				System.out.println("==================");
				System.out.println(product.toString());
				System.out.println("==================");
			});
		};
	}
}
