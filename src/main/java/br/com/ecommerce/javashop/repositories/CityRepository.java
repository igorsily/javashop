package br.com.ecommerce.javashop.repositories;

import br.com.ecommerce.javashop.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
