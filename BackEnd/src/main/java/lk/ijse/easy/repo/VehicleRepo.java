package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Vehicle;
import lk.ijse.easy.enums.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {
    @Query(value = "SELECT COUNT(*) FROM vehicle", nativeQuery = true)
    int countVehicle();

    @Query(value = "SELECT vehicleId FROM vehicle ORDER BY vehicleId DESC LIMIT 1", nativeQuery = true)
    String generateVehicleId();

    @Query(value = "SELECT * FROM vehicle WHERE vehicleType=:vehicleType",nativeQuery = true)
    List<Vehicle> getAllGenaralVehicle(@Param("vehicleType") String vehicleType);

    List<Vehicle> findByVehicleType (VehicleType vehicleType);
}
