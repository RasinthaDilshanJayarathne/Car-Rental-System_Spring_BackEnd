package lk.ijse.easy.dto;

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

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class VehicleDTO {
    private String vehicleId;
    private String registrationNo;
    private String vehicleBrand;
    private int numberOfPassengers;
    private String color;
    private VehicleType vehicleType;
    private FuelType fuelType;
    private TransmissionType transmissionType;
    private Mileage freeMileage;
    private PriceRate priceRate;
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
