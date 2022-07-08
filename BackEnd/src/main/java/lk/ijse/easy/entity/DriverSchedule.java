package lk.ijse.easy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "driveId",referencedColumnName = "driveId",insertable = false,updatable = false)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rentId",referencedColumnName = "rentId",insertable = false,updatable = false)
    private Rent rent;
}
