package ejercicio.ahmedrm.backend.resource;

import ejercicio.ahmedrm.backend.model.Brand;
import ejercicio.ahmedrm.backend.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
public class BrandResource {

    private final BrandService brandService;

    @Autowired
    public BrandResource(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<?> getAllBrands() {
        List<Brand> brands;
        try {
            brands = brandService.getAllBrands();
            return ResponseEntity.status(HttpStatus.OK).body(brands);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
