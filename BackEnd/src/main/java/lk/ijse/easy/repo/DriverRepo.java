package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver,String> {
    int countAllById(String id);

}
