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
@IdClass(RentDetail_PK.class)
public class RentDetails {

    @Id
    private String vehicleId;
    @Id
    private String rentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rentId",referencedColumnName = "rentId",insertable = false,updatable = false)
    private Rent rent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicleId",referencedColumnName = "vehicleId",insertable = false,updatable = false)
    private Vehicle vehicle;
}
