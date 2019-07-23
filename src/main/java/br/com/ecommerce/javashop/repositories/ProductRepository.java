package br.com.ecommerce.javashop.repositories;

import br.com.ecommerce.javashop.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
}
