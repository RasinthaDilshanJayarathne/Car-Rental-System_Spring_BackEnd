package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.VehicleDTO;
import lk.ijse.easy.entity.Rent;
import lk.ijse.easy.entity.RentDetails;
import lk.ijse.easy.entity.Vehicle;
import lk.ijse.easy.repo.RentRepo;
import lk.ijse.easy.repo.VehicleRepo;
import lk.ijse.easy.service.SearchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    RentRepo rentRepo;

    @Override
    public List<VehicleDTO> loadAvailableVehicles(LocalDate pickupDate, LocalDate dropOffDate) {
        LocalDate pickUpDate = pickupDate.minusDays(1);
        LocalDate returnDate = dropOffDate.plusDays(1);
        List<Rent> availableBookingList = rentRepo.findAllByReturnDateIsAfterAndPickUpDateIsBefore(pickUpDate, returnDate);
        List<Vehicle> notAvailableVehicles = new ArrayList<>();
        List<VehicleDTO> availableVehicles = new ArrayList<>();

        for (Rent rent : availableBookingList) {
            for (RentDetails bookedVehicle : rent.getRentDetails()) {
                notAvailableVehicles.add(bookedVehicle.getVehicle());
            }
        }


        L1:for (Vehicle temp : vehicleRepo.findAll()) {
            L2: for (Vehicle notAvailableVehicle : notAvailableVehicles) {
                if (temp.getVehicleId().equals(notAvailableVehicle.getVehicleId())){
                    continue L1;
                }else {
                    continue L2;
                }
            }

            availableVehicles.add(modelMapper.map(temp,VehicleDTO.class));
        }

        System.out.println("Available"+ availableVehicles.toString());
        System.out.println("Not Available"+ notAvailableVehicles.toString());
        return availableVehicles;


    }
}
