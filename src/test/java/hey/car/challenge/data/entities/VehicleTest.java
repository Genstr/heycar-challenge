package hey.car.challenge.data.entities;

import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Assertions;

import static pl.pojo.tester.api.assertion.Method.*;

class VehicleTest {

    @Test
    void testBeans() {
        Class<?>[] classes = {
                Vehicle.class
        };

        Assertions.assertPojoMethodsForAll(classes)
                .testing(GETTER, SETTER, CONSTRUCTOR)
                .quickly()
                .areWellImplemented();
    }
}
