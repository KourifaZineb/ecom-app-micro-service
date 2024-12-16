package net.kourifa.billingservice.repository;

import net.kourifa.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepositiry extends JpaRepository<Bill,Long> {
}
