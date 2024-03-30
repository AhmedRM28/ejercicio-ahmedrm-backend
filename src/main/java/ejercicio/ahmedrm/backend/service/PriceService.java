package ejercicio.ahmedrm.backend.service;

import ejercicio.ahmedrm.backend.exception.PriceException;
import ejercicio.ahmedrm.backend.model.Price;
import ejercicio.ahmedrm.backend.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    public Price getPriceById(Long priceId) {
        return priceRepository.findById(priceId).orElseThrow(() -> new PriceException("User not found"));
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

    public void deletePrice(Long priceId) throws PriceException {
        try {
            priceRepository.deletePriceById(priceId);
        } catch (Exception e) {
            throw new PriceException("Error deleting the selected price");
        }
    }
}