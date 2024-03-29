package lk.ijse.easy.controller;

import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.service.DriverService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("driver")
@CrossOrigin
public class DriverControoler {

    @Autowired
    DriverService driverService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDrivers(){
        return new ResponseUtil(200,"Driver Successfully Loaded",driverService.getAllDrivers());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriver(@RequestBody DriverDTO driver){
        System.out.println(driver.toString());
        driverService.saveDriver(driver);
        return new ResponseUtil(200,"Driver Successfully Saved",null);

    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriver(@RequestParam String id) {
        driverService.deleteDriver(id);
        return new ResponseUtil(200,"Driver Successfully Deleted",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriver(@RequestBody DriverDTO driver){
        driverService.updateDriver(driver);
        return new ResponseUtil(200,"Driver Successfully Updated",null);
    }

    @GetMapping(params= {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchDriverById(@RequestParam String id) {
        DriverDTO driverDTO = driverService.searchDriver(id);
        return new ResponseUtil(200,"Found",driverDTO);
    }

    @GetMapping(path ="/COUNT/{count}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil countDriver(@PathVariable String count){
        return new ResponseUtil(200, "Ök", driverService.countDriver());
    }

    @GetMapping(params = {"test"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateDriverIds(@RequestParam String test) {
        return new ResponseUtil(200, "Ok", driverService.generateDriverIds());
    }

//    @GetMapping( "getAvailableDriver")
//    public ResponseUtil getAvailableDriver(){
//        return new ResponseUtil(200,"OK", driverService.getAvailableDriver());
//    }

    @GetMapping( params = {"pickUpDate","returnDate"})
    public ResponseUtil getAvailableDriver(@RequestParam String pickUpDate,@RequestParam String returnDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate pickUp = LocalDate.parse(pickUpDate,formatter);
        LocalDate dropOff = LocalDate.parse(returnDate, formatter);
        return new ResponseUtil(200,"OK", driverService.loadAvailableDriver(pickUp,dropOff));
    }

    @DeleteMapping(path = "deleteDriverImage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriverAllImages(@RequestParam String id) throws IOException {
        String pathDirectory = "E:\\GDSE58-2nd_Sem\\Spring\\Car-Rental-System_BackEnd\\BackEnd\\src\\main\\resources\\static\\Image\\personalImage\\";
        String[] personalImageView = {"Nic", "License"};

        for (int i = 0; i < personalImageView.length; i++) {
            Files.deleteIfExists(Paths.get(pathDirectory + File.separator + id + personalImageView[i] + ".jpeg"));
        }

        return new ResponseUtil(200, "car Delete success", null);
    }
}
