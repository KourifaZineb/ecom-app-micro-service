package net.kourifa.customerservice;

import net.kourifa.customerservice.config.CustomerConfigParams;
import net.kourifa.customerservice.entities.Customer;
import net.kourifa.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
          customerRepository.save(Customer.builder()
                    .name("Mohammed").email("med@gmail.com")
                    .build());
          customerRepository.save(Customer.builder()
                    .name("Zineb").email("zineb@gmail.com")
                    .build());
          customerRepository.save(Customer.builder()
                    .name("Ayoub").email("ayoub@gmail.com")
                    .build());
          customerRepository.findAll().forEach(customer -> {
              System.out.println("=========================");
              System.out.println(customer.getId());
              System.out.println(customer.getName());
              System.out.println(customer.getEmail());
              System.out.println("=========================");
          });
        };
    }
}
