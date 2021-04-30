package hey.car.challenge.service;

import hey.car.challenge.data.entities.Vehicle;
import hey.car.challenge.data.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UploadJsonController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @PostMapping(value = "vehicle_listings/{dealerId}")
    public void uploadJson(
            @PathVariable String dealerId,
            @RequestBody List<Vehicle> vehicles) {

        vehicles.forEach(vehicle -> vehicle.setDealer(dealerId));
        vehicleRepository.saveAll(vehicles);
    }
}
