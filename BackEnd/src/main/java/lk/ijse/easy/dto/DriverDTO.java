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

    private String driveId;
    private String driveNic;
    private Name driveName;
    private String driveLicenseNo;
    private String driverAddress;
    private String driverContact;
    private AvailabilityType driverAvailability;
}
