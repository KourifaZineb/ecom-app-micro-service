package net.kourifa.billingservice;import net.kourifa.billingservice.entities.Bill;import net.kourifa.billingservice.entities.ProductItem;import net.kourifa.billingservice.feign.CustomerRestClient;import net.kourifa.billingservice.feign.ProductRestClient;import net.kourifa.billingservice.model.Customer;import net.kourifa.billingservice.model.Product;import net.kourifa.billingservice.repository.BillingRepositiry;import net.kourifa.billingservice.repository.ProductItemRepository;import org.springframework.boot.CommandLineRunner;import org.springframework.boot.SpringApplication;import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.cloud.openfeign.EnableFeignClients;import org.springframework.context.annotation.Bean;import java.util.Collection;import java.util.Date;import java.util.Random;@SpringBootApplication@EnableFeignClientspublic class BillingServiceApplication {	public static void main(String[] args) {		SpringApplication.run(BillingServiceApplication.class, args);	}	@Bean	CommandLineRunner commandLineRunner(BillingRepositiry billingRepository, ProductItemRepository productItemRepository			, CustomerRestClient customerRestClient			, ProductRestClient productRestClient){		Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();		Collection<Product> products = productRestClient.getAllProducts().getContent();		return args -> {			customers.forEach(customer -> {				Bill bill = Bill.builder()						.billingDate(new Date())						.customer(customer)						.customerId(customer.getId())						.build();				billingRepository.save(bill);				products.forEach(product -> {					ProductItem productItem = ProductItem.builder()							.bill(bill)							.productId(product.getId())							.quantity(1+new Random().nextInt(10))							.unitPrice(product.getPrice())							.build();					productItemRepository.save(productItem);				});			});		};	}}