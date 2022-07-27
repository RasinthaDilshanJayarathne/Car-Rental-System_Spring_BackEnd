package lk.ijse.easy.service;

import lk.ijse.easy.dto.CustomerDTO;
import lk.ijse.easy.dto.DriverDTO;

public interface SignUpService {
    void saveDriver(DriverDTO driverDTO);
    void saveCustomer(CustomerDTO customerDTO);
}
