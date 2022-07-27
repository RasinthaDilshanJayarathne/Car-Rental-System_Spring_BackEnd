package lk.ijse.easy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class DriverScheduleDTO {
    private VehicleDTO vehicle;
    private String rentId;
    private DriverDTO driver;
    private RentDTO rent;
    private String location;
}
