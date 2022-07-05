package lk.ijse.easy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RentDetailsDTO {
    private String vehicleId;
    private String rentId;
    private RentDTO rent;
    private VehicleDTO vehicle;
}
