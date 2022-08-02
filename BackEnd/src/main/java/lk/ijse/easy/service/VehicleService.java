package lk.ijse.easy.service;

import lk.ijse.easy.dto.VehicleDTO;
import lk.ijse.easy.enums.VehicleType;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);
    void deleteVehicle(String id);
    void updateVehicle(VehicleDTO vehicleDTO);
    VehicleDTO searchVehicle(String id);
    List<VehicleDTO> getAllVehicles();
    List<VehicleDTO> getAllGeneralVehicles(VehicleType vehicleType);
    int countVehicle();
    String generateVehicleIds();

}
