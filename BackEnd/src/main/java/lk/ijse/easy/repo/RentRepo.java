package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepo extends JpaRepository<Rent,String> {
}
