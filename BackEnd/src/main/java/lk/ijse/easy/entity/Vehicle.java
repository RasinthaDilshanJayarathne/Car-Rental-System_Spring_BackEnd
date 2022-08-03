package lk.ijse.easy.entity;

import lk.ijse.easy.embeded.Mileage;
import lk.ijse.easy.embeded.PriceRate;
import lk.ijse.easy.enums.AvailabilityType;
import lk.ijse.easy.enums.FuelType;
import lk.ijse.easy.enums.TransmissionType;
import lk.ijse.easy.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Data
public class Vehicle {
    @Id
    private String vehicleId;
    private String registrationNo;
    private String vehicleBrand;
    private int numberOfPassengers;
    private String color;
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @Enumerated(EnumType.STRING)
    private TransmissionType transmissionType;
    @Embedded
    private Mileage freeMileage;
    @Embedded
    private PriceRate priceRate;
    @Enumerated(EnumType.STRING)
    private AvailabilityType vehicleAvailabilityType;
    private double damageFee;
    private int lastServiceMileage;
    private int vehicleServiceMileage;
    private double pricePerExtraKM;
    private int totalVehicle;
//    private String imageOne;
//    private String imageTwo;
//    private String imageThree;
}

