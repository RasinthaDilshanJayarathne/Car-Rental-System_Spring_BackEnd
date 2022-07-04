package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.CustomerDTO;
import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.entity.Customer;
import lk.ijse.easy.entity.Driver;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.exception.NotFoundException;
import lk.ijse.easy.repo.DriverRepo;
import lk.ijse.easy.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveDriver(DriverDTO driverDTO) {
        if (!driverRepo.existsById(driverDTO.getDriveId())) {
            Driver map = modelMapper.map(driverDTO, Driver.class);
            driverRepo.save(map);
            System.out.println(driverDTO.getDriveId());
        } else {
            throw new DuplicateException("Driver Already Exist..!");
        }
    }

    @Override
    public void deleteDriver(String id) {
        if (driverRepo.existsById(id)){
            driverRepo.deleteById(id);
        }else{
            throw new NotFoundException("Please check the Driver ID.. No Such Driver..!");
        }
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {

    }

    @Override
    public DriverDTO searchDriver(String id) {
        return null;
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        if (!driverRepo.findAll().isEmpty()){
            return modelMapper.map(driverRepo.findAll(), new TypeToken<List<DriverDTO>>() {}.getType());
        }else {
            throw new NotFoundException("No Drivers in database..!");
        }
    }
}
