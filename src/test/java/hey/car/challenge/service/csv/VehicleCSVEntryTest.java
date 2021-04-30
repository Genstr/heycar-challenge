package hey.car.challenge.service.csv;

import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Assertions;

import static pl.pojo.tester.api.assertion.Method.*;

class VehicleCSVEntryTest {

    @Test
    void testBeans() {
        Class<?>[] classes = {
                VehicleCSVEntry.class
        };

        Assertions.assertPojoMethodsForAll(classes)
                .testing(GETTER, SETTER, CONSTRUCTOR)
                .quickly()
                .areWellImplemented();
    }
}
