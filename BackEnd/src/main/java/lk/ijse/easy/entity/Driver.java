package lk.ijse.easy.entity;

import lk.ijse.easy.embeded.Name;
import lk.ijse.easy.enums.AvailabilityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


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
    private AvailabilityType driverAvailability;
}
