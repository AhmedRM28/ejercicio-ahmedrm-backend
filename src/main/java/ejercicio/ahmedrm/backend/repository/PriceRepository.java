package ejercicio.ahmedrm.backend.repository;

import ejercicio.ahmedrm.backend.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;

public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query(value =
            "SELECT * FROM prices " +
            "WHERE (?1 IS NULL OR brand_id = ?1) " +
            "AND (?2 IS NULL OR product_id = ?2) " +
            "AND (?3 IS NULL OR (?3 BETWEEN start_date AND end_date)) " +
            "ORDER BY start_date DESC, priority DESC " +
            "LIMIT 1",
            nativeQuery = true)
    Price getPriceByData(Long brandId, Long productId, Date startDate);

    void deletePriceById(Long priceId);
}