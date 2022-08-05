package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Driver;
import lk.ijse.easy.enums.AvailabilityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepo extends JpaRepository<Driver,String> {

    @Query(value = "SELECT COUNT(*) FROM driver", nativeQuery = true)
    int countDriver();

    @Query(value = "SELECT id FROM driver ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String generateDriverIds();

    Driver findFirstByDriverAvailability(AvailabilityType availability);

}
