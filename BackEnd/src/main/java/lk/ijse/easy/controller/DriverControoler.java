package lk.ijse.easy.controller;

import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.service.DriverService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchDriver(@PathVariable String id) {
        DriverDTO driverDTO = driverService.searchDriver(id);
        return new ResponseUtil(200,"Found",driverDTO);
    }

    @GetMapping(path ="/COUNT/{count}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil countCustomers(@PathVariable String count){
        return new ResponseUtil(200, "Ök", driverService.countDriver());
    }
}
