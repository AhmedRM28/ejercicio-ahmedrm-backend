package ejercicio.ahmedrm.backend.service;

import ejercicio.ahmedrm.backend.exception.PriceException;
import ejercicio.ahmedrm.backend.model.Price;
import ejercicio.ahmedrm.backend.repository.PriceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> getAllPrices() {
        try {
            return priceRepository.findAll();
        } catch (Exception e) {
            throw new PriceException("Error retrieving list of prices");
        }
    }

    public Price getPriceById(Long priceId) {
        return priceRepository.findById(priceId).orElseThrow(() -> new PriceException("User not found"));
    }

    public Price getPriceData(String brand, String product, String startingDate) throws PriceException {
        try {
            Long brandId = Objects.nonNull(brand) && !Objects.equals(brand, "") ? Long.valueOf(brand) : null;
            Long productId = Objects.nonNull(product) && !Objects.equals(product, "") ? Long.valueOf(product) : null;
            Date startDate = Objects.nonNull(startingDate) && !Objects.equals(startingDate, "") ?
                    new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").parse(startingDate) : null;
            return priceRepository.getPriceByData(brandId, productId, startDate);
        } catch (Exception e) {
            throw new PriceException("Error retrieving data. " +
                    "Please check parameters format: 'brandId' and 'productId' must be numbers. " +
                    "'startDate' must follow '2020-01-15-15:30:00' format.");
        }
    }

    public Price addPrice(Price price) throws PriceException {
        try {
            return priceRepository.save(price);
        } catch (Exception e) {
            throw new PriceException("Error creating the new price");
        }
    }

    public Price updatePrice(Price price) throws PriceException {
        try {
            return priceRepository.save(price);
        } catch (Exception e) {
            throw new PriceException("Error updating the selected price");
        }
    }

    @Transactional
    public void deletePrice(Long priceId) throws PriceException {
        try {
            priceRepository.deletePriceById(priceId);
        } catch (Exception e) {
            throw new PriceException("Error deleting the selected price");
        }
    }
}