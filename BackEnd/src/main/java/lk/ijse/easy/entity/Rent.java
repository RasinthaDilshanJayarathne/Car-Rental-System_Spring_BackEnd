package lk.ijse.easy.entity;

import lk.ijse.easy.enums.RequestingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class Rent {
    @Id
    private String rentId;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private LocalDate returnDate;
    private double rentalFee;
    private double damageFee;
    private RequestingType driverRequestingType;
}
