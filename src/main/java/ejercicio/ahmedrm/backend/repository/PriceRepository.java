package ejercicio.ahmedrm.backend.repository;

import ejercicio.ahmedrm.backend.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {

    void deletePriceById(Long priceId);
}