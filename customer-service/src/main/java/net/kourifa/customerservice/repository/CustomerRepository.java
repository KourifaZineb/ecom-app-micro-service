package net.kourifa.customerservice.repository;

import net.kourifa.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
/* RepositoryRestResource c'est une annotation qui est fournie par Spring data REST et il permet de demander à Spring de démarrer
automatiquement un web service rest full qui permet d'accéder à tout les méthodes qui se trouve dans cette interface */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
