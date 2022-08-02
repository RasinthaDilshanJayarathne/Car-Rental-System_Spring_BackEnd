package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {
    @Query(value = "SELECT COUNT(*) FROM vehicle", nativeQuery = true)
    int countVehicle();
}
