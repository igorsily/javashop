package br.com.ecommerce.javashop.repositories;

import br.com.ecommerce.javashop.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
