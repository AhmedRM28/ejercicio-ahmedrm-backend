package ejercicio.ahmedrm.backend.service;

import ejercicio.ahmedrm.backend.model.Brand;
import ejercicio.ahmedrm.backend.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAllBrands() throws Exception {
        try {
            return brandRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error getting brands: Database might not be populated properly");
        }
    }

    public Brand getBrandById(Long brandId) throws Exception {
        return brandRepository.findById(brandId).orElseThrow(() -> new Exception("Error getting brand: Database might not be populated properly"));
    }
}