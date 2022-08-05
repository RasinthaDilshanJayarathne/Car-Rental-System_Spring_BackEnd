package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.RentDTO;
import lk.ijse.easy.entity.Rent;
import lk.ijse.easy.enums.RequestingType;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.exception.NotFoundException;
import lk.ijse.easy.repo.CustomerRepo;
import lk.ijse.easy.repo.RentRepo;
import lk.ijse.easy.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepo rentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public void saveRent(RentDTO dto) {
        if (!rentRepo.existsById(dto.getRentId())) {
            if(customerRepo.existsById(dto.getCustomer().getId())){
                if (!dto.getRentDetails().isEmpty()){
                    //System.out.println(dto.getNeedDriver());
                    if (dto.getDriverRequestingType() == RequestingType.YES){
                        //Driver is needed
                        if (!dto.getDriverSchedules().isEmpty()) {
                            System.out.println("Here");
                            rentRepo.save(modelMapper.map(dto, Rent.class));
                        }
                    }else {
                        //No driver Is needed
                        rentRepo.save(modelMapper.map(dto, Rent.class));
                    }
                }else {
                    throw new RuntimeException("No vehicles added for the booking..!");
                }
            }else {
                throw new NotFoundException("Customer Not Found..!");
            }
        }else {
            throw new DuplicateException("Booking already exists with this Id");
        }
        //update the vehicle

            /*for (OrderDetails  : dto.getBookedVehicleList()) {
                Item item = itemRepo.findById(orderDetail.getItemCode()).get();
                item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());
                itemRepo.save(item);
            }*/
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
            return modelMapper.map(rentRepo.findAll(), new TypeToken<List<RentDTO>>(){}.getType());
        }else {
            throw new NotFoundException("No Booking in database..!");
        }
    }

    @Override
    public int countRent() {
        return rentRepo.countRent();
    }

    @Override
    public String generateRentIds() {
        String id = rentRepo.generateRentIds();
        if (id != null) {
            int tempId = Integer.
                    parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                return "R00-00" + tempId;
            } else if (tempId <= 99) {
                return "R00-0" + tempId;
            } else {
                return "R00-" + tempId;
            }
        } else {
            return "R00-001";
        }
    }
}
