package lk.ijse.easy.controller;

import lk.ijse.easy.dto.VehicleDTO;
import lk.ijse.easy.enums.VehicleType;
import lk.ijse.easy.service.SearchService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("search")
@CrossOrigin
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping(params = {"pickupDateGenearal","returnDateGenearal"})
    public ResponseUtil loadAvailableGeneralVehicles(@RequestParam String pickupDateGenearal, @RequestParam String returnDateGenearal){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate pickUp = LocalDate.parse(pickupDateGenearal);
        LocalDate dropOff = LocalDate.parse(returnDateGenearal, formatter);
        List<VehicleDTO> vehicleDTOS = searchService.loadAvailableVehicles(pickUp, dropOff);

        List<VehicleDTO> returnVehicle = new ArrayList();

        for (VehicleDTO temp : vehicleDTOS) {
            if(temp.getVehicleType().equals(VehicleType.GENERAL)){
                returnVehicle.add(temp);
            }
        }
        return new ResponseUtil(200,"OK",returnVehicle);
    }

    @GetMapping(params = {"pickupDatePrimium","returnDatePrimium"})
    public ResponseUtil loadAvailablePrimiumVehicles(@RequestParam String pickupDatePrimium, @RequestParam String returnDatePrimium){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate pickUp = LocalDate.parse(pickupDatePrimium);
        LocalDate dropOff = LocalDate.parse(returnDatePrimium, formatter);
        List<VehicleDTO> vehicleDTOS = searchService.loadAvailableVehicles(pickUp, dropOff);

        List<VehicleDTO> returnVehicle = new ArrayList();

        for (VehicleDTO temp : vehicleDTOS) {
            if(temp.getVehicleType().equals(VehicleType.PREMIUM)){
                returnVehicle.add(temp);
            }
        }
        return new ResponseUtil(200,"OK",returnVehicle);
    }

    @GetMapping(params = {"pickupDateLuxury","returnDateLuxury"})
    public ResponseUtil loadAvailableLuxuryVehicles(@RequestParam String pickupDateLuxury, @RequestParam String returnDateLuxury){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate pickUp = LocalDate.parse(pickupDateLuxury);
        LocalDate dropOff = LocalDate.parse(returnDateLuxury, formatter);
        List<VehicleDTO> vehicleDTOS = searchService.loadAvailableVehicles(pickUp, dropOff);

        List<VehicleDTO> returnVehicle = new ArrayList();

        for (VehicleDTO temp : vehicleDTOS) {
            if(temp.getVehicleType().equals(VehicleType.PREMIUM)){
                returnVehicle.add(temp);
            }
        }
        return new ResponseUtil(200,"OK",returnVehicle);
    }
}
