package net.kourifa.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "email", types = Customer.class)
public interface CustomerProjection2 {

    String getEmail();
}
