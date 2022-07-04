package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.VehicleDTO;
import lk.ijse.easy.entity.Driver;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.exception.NotFoundException;
import lk.ijse.easy.repo.DriverRepo;
import lk.ijse.easy.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        if (!driverRepo.existsById(vehicleDTO.getVehicleId())) {
            Driver map = modelMapper.map(vehicleDTO, Driver.class);
            System.out.println(map.toString());
            driverRepo.save(map);
            System.out.println(vehicleDTO.getVehicleId());
        } else {
            throw new DuplicateException("Vehicle Already Exist..!");
        }
    }

    @Override
    public void deleteVehicle(String id) {
        if (driverRepo.existsById(id)){
            driverRepo.deleteById(id);
        }else{
            throw new NotFoundException("Please check the Vehicle ID.. No Such Vehicle..!");
        }
    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {
        if (driverRepo.existsById(vehicleDTO.getVehicleId())){
            Driver map = modelMapper.map(vehicleDTO, Driver.class);
            driverRepo.save(map);
        }else {
            throw new NotFoundException("No Such a Vehicle..!");
        }
    }

    @Override
    public VehicleDTO searchVehicle(String id) {
        return null;
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return null;
    }
}
