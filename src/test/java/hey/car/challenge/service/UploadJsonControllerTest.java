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
import org.springframework.data.domain.Example;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
@TestPropertySource("classpath:test.properties")
class UploadJsonControllerTest {

    @Autowired
    private UploadJsonController uploadJsonController;

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

        vehicle.setCode(code);
        vehicle.setMake(make);
        vehicle.setModel(model);
        vehicle.setPower(power);
        vehicle.setYear(year);
        vehicle.setColor(color);
        vehicle.setPrice(price);
    }

    @AfterEach
    private void cleanup() {
        vehicleRepository.delete(vehicle);
    }

    @Test
    void testUploadJson() {
        uploadJsonController.uploadJson(dealer, Arrays.asList(vehicle));

        vehicle.setDealer(dealer);
        Optional<Vehicle> resultOptional = vehicleRepository.findOne(Example.of(vehicle));
        Assertions.assertTrue(resultOptional.isPresent());
    }
}
