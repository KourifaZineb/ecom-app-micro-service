package net.kourifa.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.kourifa.billingservice.model.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems = new ArrayList<>();
//    il indique à JPA que cette attribut il existe dans la classe mais il n'est pas represente dans
//    la base de donnees c'est a dire que JPA va l'ignorer
    @Transient
    private Customer customer;
}
