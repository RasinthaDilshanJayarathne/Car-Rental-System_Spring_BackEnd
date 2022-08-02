package lk.ijse.easy.service;

import lk.ijse.easy.dto.RentDTO;

import java.util.List;

public interface RentService {
    void saveRent(RentDTO rentDTO);
    void deleteRent(String id);
    void updateRent(RentDTO rentDTO);
    RentDTO searchRent(String id);
    List<RentDTO> getAllRents();
    int countRent();
}
