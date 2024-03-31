package ejercicio.ahmedrm.backend.repository;

import ejercicio.ahmedrm.backend.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> { }