package br.com.ecommerce.javashop.repositories;

import br.com.ecommerce.javashop.models.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<States, Long> {
}
