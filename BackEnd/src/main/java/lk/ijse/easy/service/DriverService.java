package lk.ijse.easy.service;

import lk.ijse.easy.dto.DriverDTO;

import java.time.LocalDate;
import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO driverDTO);
    void deleteDriver(String id);
    void updateDriver(DriverDTO driverDTO);
    DriverDTO searchDriver(String id);
    List<DriverDTO> getAllDrivers();
    int countDriver();
    String generateDriverIds();
    DriverDTO loadAvailableDriver(LocalDate pickupDate, LocalDate dropOffDate);
    DriverDTO getAvailableDriver();
}
