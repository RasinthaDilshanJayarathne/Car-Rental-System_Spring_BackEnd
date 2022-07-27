package lk.ijse.easy.dto;

import lk.ijse.easy.embeded.Name;
import lk.ijse.easy.enums.AvailabilityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class DriverDTO {

    private String id;
    private String nic;
    private Name name;
    private String licenseNo;
    private String address;
    private String contactNo;
    private AvailabilityType driverAvailability;
    private UserDTO user;
}
