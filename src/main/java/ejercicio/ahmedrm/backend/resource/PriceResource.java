package ejercicio.ahmedrm.backend.resource;

import ejercicio.ahmedrm.backend.exception.PriceException;
import ejercicio.ahmedrm.backend.model.Price;
import ejercicio.ahmedrm.backend.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/price")
public class PriceResource {

    private final PriceService priceService;

    @Autowired
    public PriceResource(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPrices() {
        List<Price> prices;
        try {
            prices = priceService.getAllPrices();
            return ResponseEntity.status(HttpStatus.OK).body(prices);
        } catch (PriceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unhandled server error");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPricesById(@PathVariable("id") Long priceId) {
        Price price;
        try {
            price = priceService.getPriceById(priceId);
            return new ResponseEntity<>(price, HttpStatus.OK);
        } catch (PriceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unhandled server error");
        }
    }

    @GetMapping("/data")
    public ResponseEntity<?> getPriceData(@RequestParam Map<String, String> queryParams) {
        Price price;
        try {
            price = priceService.getPriceData(queryParams.get("brandId"), queryParams.get("productId"), queryParams.get("startDate"));
            return ResponseEntity.status(HttpStatus.OK).body(price);
        } catch (PriceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unhandled server error");
        }
    }

    @PostMapping
    public ResponseEntity<?> addPrice(@RequestBody Price newPrice) {
        Price price;
        try {
            price = priceService.addPrice(newPrice);
            return new ResponseEntity<>(price, HttpStatus.CREATED);
        } catch (PriceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unhandled server error");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePrice(@RequestBody Price updatedPrice) {
        Price price;
        try {
            price = priceService.updatePrice(updatedPrice);
            return new ResponseEntity<>(price, HttpStatus.OK);
        } catch (PriceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unhandled server error");
        }
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrice(@PathVariable("id") Long priceId) {
       try {
           priceService.deletePrice(priceId);
           return new ResponseEntity<>(HttpStatus.OK);
       } catch (PriceException e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unhandled server error");
       }
    }

}