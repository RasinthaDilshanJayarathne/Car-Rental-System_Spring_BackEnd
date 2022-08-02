package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepo extends JpaRepository<Driver,String> {

    @Query(value = "SELECT COUNT(*) FROM driver", nativeQuery = true)
    int countDriver();

}
