package hey.car.challenge.data.repositories;

import hey.car.challenge.data.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Vehicle.CompositeId>, QueryByExampleExecutor<Vehicle> {
}
