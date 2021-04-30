package hey.car.challenge.service;

import hey.car.challenge.data.entities.Vehicle;
import hey.car.challenge.data.repositories.VehicleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
@TestPropertySource("classpath:test.properties")
class SearchControllerTest {

    @Autowired
    private SearchController searchController;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Value("${dealer}")
    private String dealer;

    @Value("${code}")
    private String code;

    @Value("${make}")
    private String make;

    @Value("${model}")
    private String model;

    @Value("${power}")
    private int power;

    @Value("${color}")
    private String color;

    @Value("${year}")
    private int year;

    @Value("${price}")
    private double price;

    private Vehicle vehicle;

    @BeforeEach
    private void init() {
        vehicle = new Vehicle();
        vehicle.setDealer(dealer);
        vehicle.setCode(code);
        vehicle.setMake(make);
        vehicle.setModel(model);
        vehicle.setPower(power);
        vehicle.setYear(year);
        vehicle.setColor(color);
        vehicle.setPrice(price);

        vehicleRepository.save(vehicle);
    }

    @AfterEach
    private void cleanup() {
        vehicleRepository.delete(vehicle);
    }

    @Test
    void testSearchAll() {
        List<Vehicle> vehicles = searchController.search(null, null, null, null);
        Assertions.assertNotNull(vehicles);
        Assertions.assertTrue(vehicles.size() > 0);
    }

    @Test
    void testSearchByAllParams() {
        List<Vehicle> vehicles = searchController.search(make, model, color, year);
        Assertions.assertNotNull(vehicles);
        Assertions.assertTrue(vehicles.size() > 0);
    }

    @Test
    void testSearchByMake() {
        List<Vehicle> vehicles = searchController.search(make, null, null, null);
        Assertions.assertNotNull(vehicles);
        Assertions.assertTrue(vehicles.size() > 0);
    }

    @Test
    void testSearchByModel() {
        List<Vehicle> vehicles = searchController.search(null, model, null, null);
        Assertions.assertNotNull(vehicles);
        Assertions.assertTrue(vehicles.size() > 0);
    }

    @Test
    void testSearchByColor() {
        List<Vehicle> vehicles = searchController.search(null, null, color, null);
        Assertions.assertNotNull(vehicles);
        Assertions.assertTrue(vehicles.size() > 0);
    }

    @Test
    void testSearchByYear() {
        List<Vehicle> vehicles = searchController.search(null, null, null, year);
        Assertions.assertNotNull(vehicles);
        Assertions.assertTrue(vehicles.size() > 0);
    }
}
