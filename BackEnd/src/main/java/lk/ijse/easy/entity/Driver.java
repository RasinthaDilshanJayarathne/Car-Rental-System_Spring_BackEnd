package lk.ijse.easy.entity;

import lk.ijse.easy.embeded.Name;
import lk.ijse.easy.enums.DriverAvailability;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Data
public class Driver {
    @Id
    private String driveId;
    private String driveNic;
    @Embedded
    private Name driveName;
    private String driveLicenseNo;
    private String driverAddress;
    private String driverContact;
    private DriverAvailability driverAvailability;
}