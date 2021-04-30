package hey.car.challenge.service;

import hey.car.challenge.data.entities.Vehicle;
import hey.car.challenge.data.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/search")
    public List<Vehicle> search(
            @RequestParam(required = false) String make,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Integer year) {
        if(make == null && model == null && color == null && year == null) {
            return vehicleRepository.findAll();
        } else {
            var vehicle = new Vehicle();
            vehicle.setMake(make);
            vehicle.setModel(model);
            vehicle.setColor(color);
            if(year != null) {
                vehicle.setYear(year);
            }

            return vehicleRepository.findAll(Example.of(vehicle));
        }
    }
}
