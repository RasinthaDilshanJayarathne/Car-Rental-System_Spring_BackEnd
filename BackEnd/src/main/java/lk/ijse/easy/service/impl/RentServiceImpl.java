package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.dto.RentDTO;
import lk.ijse.easy.entity.Driver;
import lk.ijse.easy.entity.Rent;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.exception.NotFoundException;
import lk.ijse.easy.repo.RentRepo;
import lk.ijse.easy.service.RentService;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@ToString
@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepo rentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveRent(RentDTO rentDTO) {
        if (!rentRepo.existsById(rentDTO.getRentId())) {
            Rent map = modelMapper.map(rentDTO, Rent.class);
            rentRepo.save(map);
            System.out.println(rentDTO.getRentId());
        } else {
            throw new DuplicateException("Booking Already Exist..!");
        }
    }

    @Override
    public void deleteRent(String id) {
        if (rentRepo.existsById(id)){

            rentRepo.deleteById(id);
        }else{
            throw new NotFoundException("Please check the Booking ID.. No Such Booking..!");
        }
    }

    @Override
    public void updateRent(RentDTO rentDTO) {
        if (rentRepo.existsById(rentDTO.getRentId())){
            Rent map = modelMapper.map(rentDTO, Rent.class);
            rentRepo.save(map);
        }else {
            throw new NotFoundException("No Such a Booking..!");
        }
    }

    @Override
    public RentDTO searchRent(String id) {
        if (rentRepo.existsById(id)){
            Rent rent = rentRepo.findById(id).get();
            return modelMapper.map(rent, RentDTO.class);
        }else{
            throw new NotFoundException("No Booking For "+ id +" ..!");
        }
    }

    @Override
    public List<RentDTO> getAllRents() {
        if (!rentRepo.findAll().isEmpty()){
            return modelMapper.map(rentRepo.findAll(), new TypeToken<List<RentDTO>>() {}.getType());
        }else {
            throw new NotFoundException("No Booking in database..!");
        }
    }
}
