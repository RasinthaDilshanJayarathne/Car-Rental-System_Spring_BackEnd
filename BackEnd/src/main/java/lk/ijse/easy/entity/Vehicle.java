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

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

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
    private VehicleType vehicleType;
    private FuelType fuelType;
    private TransmissionType transmissionType;
    @Embedded
    private Mileage mileage;
    @Embedded
    private PriceRate priceRate;
    private AvailabilityType vehicleAvailabilityType;
    private double damageFee;
}

