package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.RentDTO;
import lk.ijse.easy.entity.Driver;
import lk.ijse.easy.entity.Rent;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.exception.NotFoundException;
import lk.ijse.easy.repo.RentRepo;
import lk.ijse.easy.service.RentService;
import lombok.ToString;
import org.modelmapper.ModelMapper;
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

    }

    @Override
    public RentDTO searchRent(String id) {
        return null;
    }

    @Override
    public List<RentDTO> getAllRents() {
        return null;
    }
}
