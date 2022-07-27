package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.CustomerDTO;
import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.entity.Customer;
import lk.ijse.easy.entity.Driver;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.repo.CustomerRepo;
import lk.ijse.easy.repo.DriverRepo;
import lk.ijse.easy.repo.UserRepo;
import lk.ijse.easy.service.SignUpService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public void saveDriver(DriverDTO driverDTO) {
        if (!driverRepo.existsById(driverDTO.getId())) {
            if (!userRepo.existsByUserName(driverDTO.getUser().getUserName())) {
                driverRepo.save(mapper.map(driverDTO, Driver.class));
            } else {
                throw new DuplicateException("User Name Already Exists");
            }
        }else{
            throw new DuplicateException("Driver Already Exists");
        }
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getId())) {
            if (!userRepo.existsByUserName(customerDTO.getUser().getUserName())) {
                customerRepo.save(mapper.map(customerDTO, Customer.class));
            } else {
                throw new DuplicateException("User Name Already Exists");
            }
        }else{
            throw new DuplicateException("Customer Already Exists");
        }
    }
}
