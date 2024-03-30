package ejercicio.ahmedrm.backend.resource;

import ejercicio.ahmedrm.backend.model.Price;
import ejercicio.ahmedrm.backend.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/price")
public class PriceResource {

    private final PriceService priceService;

    @Autowired
    public PriceResource(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<List<Price>> getAllPrices() {
        List<Price> prices = priceService.getAllPrices();
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Price> getPricesById(@PathVariable("id") Long priceId) {
        Price price = priceService.getPriceById(priceId);
        return new ResponseEntity<>(price, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Price> addPrice(@RequestBody Price newPrice) {
        Price price = priceService.addPrice(newPrice);
        return new ResponseEntity<>(price, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Price> updatePrice(@RequestBody Price updatedPrice) {
        Price price = priceService.updatePrice(updatedPrice);
        return new ResponseEntity<>(price, HttpStatus.OK);
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrice(@PathVariable("id") Long priceId) {
        priceService.deletePrice(priceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}