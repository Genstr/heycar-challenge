package hey.car.challenge.service;

import com.opencsv.bean.CsvToBeanBuilder;
import hey.car.challenge.data.entities.Vehicle;
import hey.car.challenge.data.repositories.VehicleRepository;
import hey.car.challenge.service.csv.VehicleCSVEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.StringReader;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
public class UploadCSVController {

    private static Logger logger = LoggerFactory
            .getLogger(UploadCSVController.class);

    @Autowired
    private VehicleRepository vehicleRepository;

    @PostMapping(value = "upload_csv/{dealerId}", consumes = {"text/csv"})
    public void uploadCSV(
            @PathVariable String dealerId,
            @RequestBody String csv) {

        try(var reader = new StringReader(csv)) {
            var parsingExceptionsNumber = new AtomicInteger();
            List<VehicleCSVEntry> vehicleCSVEntries = new CsvToBeanBuilder<VehicleCSVEntry>(reader)
                    .withType(VehicleCSVEntry.class)
                    .withExceptionHandler(csvException -> {
                        parsingExceptionsNumber.getAndIncrement();
                        logger.error("Exception on parsing CSV request body:", csvException);
                        return csvException;
                    })
                    .build()
                    .parse();

            if(vehicleCSVEntries != null) {
                List<Vehicle> vehicles = vehicleCSVEntries.stream()
                        .map(vehicleCSVEntry -> {
                            var vehicle = vehicleCSVEntry.toVehicle();
                            vehicle.setDealer(dealerId);
                            return vehicle;
                        })
                        .collect(Collectors.toList());
                vehicleRepository.saveAll(vehicles);
            }

            if(parsingExceptionsNumber.get() > 0) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Invalid csv format! Number of processing exceptions: "
                                + parsingExceptionsNumber.get());
            }
        }
    }
}
