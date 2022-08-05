package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.entity.Customer;
import lk.ijse.easy.entity.Driver;
import lk.ijse.easy.entity.DriverSchedule;
import lk.ijse.easy.entity.Rent;
import lk.ijse.easy.enums.AvailabilityType;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.exception.NotFoundException;
import lk.ijse.easy.repo.DriverRepo;
import lk.ijse.easy.repo.RentRepo;
import lk.ijse.easy.repo.UserRepo;
import lk.ijse.easy.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    RentRepo rentRepo;

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

    @Override
    public String generateDriverIds() {
        String id = driverRepo.generateDriverIds();
        if (id != null) {
            int tempId = Integer.
                    parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                return "D00-00" + tempId;
            } else if (tempId <= 99) {
                return "D00-0" + tempId;
            } else {
                return "D00-" + tempId;
            }
        } else {
            return "D00-001";
        }
    }

    @Override
    public DriverDTO loadAvailableDriver(LocalDate pickupDate, LocalDate dropOffDate) {
        LocalDate pickUpDate = pickupDate.minusDays(1);
        LocalDate returnDate = dropOffDate.plusDays(1);
        List<Rent> notAvailableBookingList = rentRepo.findAllByReturnDateIsAfterAndPickUpDateIsBefore(pickUpDate, returnDate);
        List<Driver> notAvailableDrivers = new ArrayList<>();

        for (Rent rent : notAvailableBookingList) {
            for (DriverSchedule bookedDriver : rent.getDriverSchedules()) {
                notAvailableDrivers.add(bookedDriver.getDriver());
            }
        }

        L1:
        for (Driver temp : driverRepo.findAll()) {
            L2:
            for (Driver notAvailableDriver : notAvailableDrivers) {
                if (temp.getId().equals(notAvailableDriver.getId())) {
                    continue L1;
                } else {
                    continue L2;
                }
            }
            return modelMapper.map(temp, DriverDTO.class);
        }
        throw new RuntimeException("No Driver Available");
    }

    @Override
    public DriverDTO getAvailableDriver() {
        Driver availableDriver = driverRepo.findFirstByDriverAvailability(AvailabilityType.AVAILABLE);

        return modelMapper.map(availableDriver,DriverDTO.class);
    }

}
