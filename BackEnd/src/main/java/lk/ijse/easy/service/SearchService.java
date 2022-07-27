package lk.ijse.easy.service;

import lk.ijse.easy.dto.VehicleDTO;

import java.time.LocalDate;
import java.util.List;

public interface SearchService {
    List<VehicleDTO> loadAvailableVehicles(LocalDate pickupDate, LocalDate returnDate);
}
