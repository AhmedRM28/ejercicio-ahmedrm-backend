package ejercicio.ahmedrm.backend.repository;

import ejercicio.ahmedrm.backend.model.Price;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceRepositoryRestEndpointTests {

    @Autowired
    TestRestTemplate testRestTemplate;

    private String baseUrl = "http://localhost:8080/api/price";


    @DisplayName("Test 1: First pettition")
    @Test
    @Order(1)
    void addFirstPriceTest() throws ParseException {
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "/data")
                .queryParam("brandId", "1")
                .queryParam("productId", "35455")
                .queryParam("startDate", "2020-06-14-10:00:00")
                .build().toUri();

        Long testedBrandId = 1L;
        Long testedProductId = 35455L;
        Date testedDate = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").parse("2020-06-14-10:00:00");

        ResponseEntity<?> response = testRestTemplate.getForEntity(uri, Price.class);
        assertEquals(HttpStatus.OK, response.getStatusCode(), "API call is expected to return a OK (200) status code");

        Price price = (Price) response.getBody();
        assertNotNull(price, "API is expected to return a non-null price object");

        assertTrue(!price.getStartDate().after(testedDate) && !price.getEndDate().before(testedDate),
                "The specified date is expected to be inside the range of dates of the resultant price");

        assertEquals(testedBrandId, price.getBrand().getId(), "The price brand ID is expected to be '1'");

        assertEquals(testedProductId, price.getProductId(), "The price product ID is expected to be '35455'");

//        assertEquals(1, price.getId(), "Personal testing");

        System.out.println("Tested ProductId: " + testedProductId);
        System.out.println("Tested BrandId: "   + testedBrandId);
        System.out.println("Tested StartDate: " + testedDate);
        System.out.println("\nResults");
        System.out.println("ProductId: " + price.getProductId());
        System.out.println("BrandId: "   + price.getBrand().getId());
        System.out.println("PriceList: " + price.getPriceList());
        System.out.println("StartDate: " + price.getStartDate());
        System.out.println("EndDate: "   + price.getEndDate());
        System.out.println("Price: "     + price.getPrice());
    }

    @DisplayName("Test 2: Second pettition")
    @Test
    @Order(2)
    void addSecondPriceTest() throws Exception {
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "/data")
                .queryParam("brandId", "1")
                .queryParam("productId", "35455")
                .queryParam("startDate", "2020-06-14-16:00:00")
                .build().toUri();

        Long testedBrandId = 1L;
        Long testedProductId = 35455L;
        Date testedDate = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").parse("2020-06-14-16:00:00");

        ResponseEntity<?> response = testRestTemplate.getForEntity(uri, Price.class);
        assertEquals(HttpStatus.OK, response.getStatusCode(), "API call is expected to return a OK (200) status code");

        Price price = (Price) response.getBody();
        assertNotNull(price, "API is expected to return a non-null price object");

        assertTrue(!price.getStartDate().after(testedDate) && !price.getEndDate().before(testedDate),
                "The specified date is expected to be inside the range of dates of the resultant price");

        assertEquals(testedBrandId, price.getBrand().getId(), "The price brand ID is expected to be '1'");

        assertEquals(testedProductId, price.getProductId(), "The price product ID is expected to be '35455'");

//        assertEquals(2, price.getId(), "Personal testing");

        System.out.println("Tested ProductId: " + testedProductId);
        System.out.println("Tested BrandId: "   + testedBrandId);
        System.out.println("Tested StartDate: " + testedDate);
        System.out.println("\nResults");
        System.out.println("ProductId: " + price.getProductId());
        System.out.println("BrandId: "   + price.getBrand().getId());
        System.out.println("PriceList: " + price.getPriceList());
        System.out.println("StartDate: " + price.getStartDate());
        System.out.println("EndDate: "   + price.getEndDate());
        System.out.println("Price: "     + price.getPrice());
    }

    @DisplayName("Test 3: Third petition")
    @Test
    @Order(3)
    void addThirdPriceTest() throws Exception {
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "/data")
                .queryParam("brandId", "1")
                .queryParam("productId", "35455")
                .queryParam("startDate", "2020-06-14-21:00:00")
                .build().toUri();

        Long testedBrandId = 1L;
        Long testedProductId = 35455L;
        Date testedDate = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").parse("2020-06-14-21:00:00");

        ResponseEntity<?> response = testRestTemplate.getForEntity(uri, Price.class);
        assertEquals(HttpStatus.OK, response.getStatusCode(), "API call is expected to return a OK (200) status code");

        Price price = (Price) response.getBody();
        assertNotNull(price, "API is expected to return a non-null price object");

        assertTrue(!price.getStartDate().after(testedDate) && !price.getEndDate().before(testedDate),
                "The specified date is expected to be inside the range of dates of the resultant price");

        assertEquals(testedBrandId, price.getBrand().getId(), "The price brand ID is expected to be '1'");

        assertEquals(testedProductId, price.getProductId(), "The price product ID is expected to be '35455'");

//        assertEquals(1, price.getId(), "Personal testing");

        System.out.println("Tested ProductId: " + testedProductId);
        System.out.println("Tested BrandId: "   + testedBrandId);
        System.out.println("Tested StartDate: " + testedDate);
        System.out.println("\nResults");
        System.out.println("ProductId: " + price.getProductId());
        System.out.println("BrandId: "   + price.getBrand().getId());
        System.out.println("PriceList: " + price.getPriceList());
        System.out.println("StartDate: " + price.getStartDate());
        System.out.println("EndDate: "   + price.getEndDate());
        System.out.println("Price: "     + price.getPrice());
    }

    @DisplayName("Test 4: Fourth petition")
    @Test
    @Order(4)
    void addFourthPriceTest() throws Exception {
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "/data")
                .queryParam("brandId", "1")
                .queryParam("productId", "35455")
                .queryParam("startDate", "2020-06-15-10:00:00")
                .build().toUri();

        Long testedBrandId = 1L;
        Long testedProductId = 35455L;
        Date testedDate = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").parse("2020-06-15-10:00:00");

        ResponseEntity<?> response = testRestTemplate.getForEntity(uri, Price.class);
        assertEquals(HttpStatus.OK, response.getStatusCode(), "API call is expected to return a OK (200) status code");

        Price price = (Price) response.getBody();
        assertNotNull(price, "API is expected to return a non-null price object");

        assertTrue(!price.getStartDate().after(testedDate) && !price.getEndDate().before(testedDate),
                "The specified date is expected to be inside the range of dates of the resultant price");

        assertEquals(testedBrandId, price.getBrand().getId(), "The price brand ID is expected to be '1'");

        assertEquals(testedProductId, price.getProductId(), "The price product ID is expected to be '35455'");

//        assertEquals(3, price.getId(), "Personal testing");

        System.out.println("Tested ProductId: " + testedProductId);
        System.out.println("Tested BrandId: "   + testedBrandId);
        System.out.println("Tested StartDate: " + testedDate);
        System.out.println("\nResults");
        System.out.println("ProductId: " + price.getProductId());
        System.out.println("BrandId: "   + price.getBrand().getId());
        System.out.println("PriceList: " + price.getPriceList());
        System.out.println("StartDate: " + price.getStartDate());
        System.out.println("EndDate: "   + price.getEndDate());
        System.out.println("Price: "     + price.getPrice());
    }


    @DisplayName("Test 5: Fifth petition")
    @Test
    @Order(5)
    void addFifthPriceTest() throws ParseException {
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "/data")
                .queryParam("brandId", "1")
                .queryParam("productId", "35455")
                .queryParam("startDate", "2020-06-162-21:00:00")
                .build().toUri();

        Long testedBrandId = 1L;
        Long testedProductId = 35455L;
        Date testedDate = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").parse("2020-06-16-21:00:00");

        ResponseEntity<?> response = testRestTemplate.getForEntity(uri, Price.class);
        assertEquals(HttpStatus.OK, response.getStatusCode(), "API call is expected to return a OK (200) status code");

        Price price = (Price) response.getBody();
        assertNotNull(price, "API is expected to return a non-null price object");

        assertTrue(!price.getStartDate().after(testedDate) && !price.getEndDate().before(testedDate),
                "The specified date is expected to be inside the range of dates of the resultant price");

        assertEquals(testedBrandId, price.getBrand().getId(), "The price brand ID is expected to be '1'");

        assertEquals(testedProductId, price.getProductId(), "The price product ID is expected to be '35455'");

//        assertEquals(4, price.getId(), "Personal testing");

        System.out.println("Tested ProductId: " + testedProductId);
        System.out.println("Tested BrandId: "   + testedBrandId);
        System.out.println("Tested StartDate: " + testedDate);
        System.out.println("\nResults");
        System.out.println("ProductId: " + price.getProductId());
        System.out.println("BrandId: "   + price.getBrand().getId());
        System.out.println("PriceList: " + price.getPriceList());
        System.out.println("StartDate: " + price.getStartDate());
        System.out.println("EndDate: "   + price.getEndDate());
        System.out.println("Price: "     + price.getPrice());
    }
}