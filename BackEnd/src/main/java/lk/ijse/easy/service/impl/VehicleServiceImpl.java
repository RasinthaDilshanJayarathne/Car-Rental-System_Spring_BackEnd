package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.dto.VehicleDTO;
import lk.ijse.easy.entity.Driver;
import lk.ijse.easy.entity.Vehicle;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.exception.NotFoundException;
import lk.ijse.easy.repo.DriverRepo;
import lk.ijse.easy.repo.VehicleRepo;
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
    VehicleRepo vehicleRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        if (!vehicleRepo.existsById(vehicleDTO.getVehicleId())) {
            Driver map = modelMapper.map(vehicleDTO, Driver.class);
            System.out.println(map.toString());
            vehicleRepo.save(map);
        } else {
            throw new DuplicateException("Vehicle Already Exist..!");
        }
    }

    @Override
    public void deleteVehicle(String id) {
        if (vehicleRepo.existsById(id)){
            vehicleRepo.deleteById(id);
        }else{
            throw new NotFoundException("Please check the Vehicle ID.. No Such Vehicle..!");
        }
    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getVehicleId())){
            Driver map = modelMapper.map(vehicleDTO, VehicleDTO.class);
            vehicleRepo.save(map);
        }else {
            throw new NotFoundException("No Such a Vehicle..!");
        }
    }

    @Override
    public VehicleDTO searchVehicle(String id) {
        if (vehicleRepo.existsById(id)){
            Vehicle vehicle = vehicleRepo.findById(id).get();
            return modelMapper.map(vehicle, VehicleDTO.class);
        }else{
            throw new NotFoundException("No Vehicle For "+ id +" ..!");
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return null;
    }
}
