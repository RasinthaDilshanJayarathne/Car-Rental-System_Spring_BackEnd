package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.entity.Customer;
import lk.ijse.easy.entity.Driver;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.exception.NotFoundException;
import lk.ijse.easy.repo.DriverRepo;
import lk.ijse.easy.repo.UserRepo;
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
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveDriver(DriverDTO driverDTO) {
        if (!driverRepo.existsById(driverDTO.getId())) {
            if (!userRepo.existsByUserName(driverDTO.getUser().getUserName())){
                Driver map = modelMapper.map(driverDTO, Driver.class);
                driverRepo.save(map);
            }else {
                throw new DuplicateException("User Already Exist..!");
            }

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
        if (driverRepo.existsById(driverDTO.getId())){
            Driver map = modelMapper.map(driverDTO, Driver.class);
            driverRepo.save(map);
        }else {
            throw new NotFoundException("No Such a Driver..!");
        }
    }

    @Override
    public DriverDTO searchDriver(String id) {
        if (driverRepo.existsById(id)){
            Driver driver = driverRepo.findById(id).get();
            return modelMapper.map(driver, DriverDTO.class);
        }else{
            throw new NotFoundException("No Driver For "+ id +" ..!");
        }
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        if (!driverRepo.findAll().isEmpty()){
            return modelMapper.map(driverRepo.findAll(), new TypeToken<List<DriverDTO>>() {}.getType());
        }else {
            throw new NotFoundException("No Drivers in database..!");
        }
    }

    @Override
    public int countDriver() {
        return driverRepo.countDriver();
    }

}
