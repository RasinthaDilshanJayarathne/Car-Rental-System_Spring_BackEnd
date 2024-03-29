package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RentRepo extends JpaRepository<Rent,String> {
    List<Rent> findAllByReturnDateIsAfterAndPickUpDateIsBefore(LocalDate pickUpDate, LocalDate returnDate);

    @Query(value = "SELECT COUNT(*) FROM rent", nativeQuery = true)
    int countRent();

    @Query(value = "SELECT rentId FROM rent ORDER BY rentId DESC LIMIT 1", nativeQuery = true)
    String generateRentIds();
}
