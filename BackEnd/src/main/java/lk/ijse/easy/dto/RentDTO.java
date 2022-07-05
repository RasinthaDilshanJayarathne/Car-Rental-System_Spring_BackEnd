package lk.ijse.easy.dto;

import lk.ijse.easy.entity.RentDetails;
import lk.ijse.easy.enums.RequestingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RentDTO {
    private String rentId;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private LocalDate returnDate;
    private double rentalFee;
    private double damageFee;
    private RequestingType driverRequestingType;
    private CustomerDTO customer;
    private List<DriverScheduleDTO> driverSchedules;
    private List<RentDetailsDTO> rentDetails;
}
