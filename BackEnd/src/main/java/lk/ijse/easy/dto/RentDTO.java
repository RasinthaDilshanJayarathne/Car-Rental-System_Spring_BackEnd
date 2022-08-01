package lk.ijse.easy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate pickUpDate;
    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime pickUpTime;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate returnDate;
    private RequestingType driverRequestingType;
    private String location;
    private CustomerDTO customer;
    private List<DriverScheduleDTO> driverSchedules;
    private List<RentDetailsDTO> rentDetails;

}
