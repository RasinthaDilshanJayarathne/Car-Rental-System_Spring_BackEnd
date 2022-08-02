package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.VehicleDTO;
import lk.ijse.easy.entity.Vehicle;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.exception.NotFoundException;
import lk.ijse.easy.repo.VehicleRepo;
import lk.ijse.easy.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
            Vehicle map = modelMapper.map(vehicleDTO, Vehicle.class);
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
            Vehicle map = modelMapper.map(vehicleDTO, Vehicle.class);
            vehicleRepo.save(map);
        }else {
            throw new NotFoundException("No Such a Driver..!");
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
        if (!vehicleRepo.findAll().isEmpty()){
            return modelMapper.map(vehicleRepo.findAll(), new TypeToken<List<VehicleDTO>>() {}.getType());
        }else {
            throw new NotFoundException("No Vehicles in database..!");
        }
    }

    @Override
    public int countVehicle() {
        return vehicleRepo.countVehicle();
    }
}
