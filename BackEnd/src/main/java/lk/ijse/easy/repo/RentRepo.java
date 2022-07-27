package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RentRepo extends JpaRepository<Rent,String> {
    List<Rent> findAllByReturnDateIsAfterAndPickUpDateIsBefore(LocalDate pickUpDate, LocalDate returnDate);
}
