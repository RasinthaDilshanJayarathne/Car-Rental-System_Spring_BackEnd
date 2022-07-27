package lk.ijse.easy.entity;

import lk.ijse.easy.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@IdClass(DriverSchedule_PK.class)
public class DriverSchedule {

    @Id
    private String driveId;
    @Id
    private String rentId;
    @Embedded
    private Name name;
    private String vehicleBrand;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private String location;

    @ManyToOne
    @JoinColumn(name = "driveId",referencedColumnName = "id",insertable = false,updatable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "rentId",referencedColumnName = "rentId",insertable = false,updatable = false)
    private Rent rent;
}
