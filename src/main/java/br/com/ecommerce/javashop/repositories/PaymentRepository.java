package br.com.ecommerce.javashop.repositories;

import br.com.ecommerce.javashop.models.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Long> {
}
