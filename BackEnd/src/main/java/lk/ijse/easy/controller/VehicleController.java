package lk.ijse.easy.controller;

import lk.ijse.easy.dto.VehicleDTO;
import lk.ijse.easy.service.VehicleService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllVehicles(){
        return new ResponseUtil(200,"Vehicle Successfully Loaded",vehicleService.getAllVehicles());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveVehicle(@RequestBody VehicleDTO vehicle){
        System.out.println(vehicle.toString());
        vehicleService.saveVehicle(vehicle);
        return new ResponseUtil(200,"Vehicle Successfully Saved",null);

    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteVehicle(@RequestParam String id) {
        vehicleService.deleteVehicle(id);
        return new ResponseUtil(200,"Vehicle Successfully Deleted",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateVehicle(@RequestBody VehicleDTO driver){
        vehicleService.updateVehicle(driver);
        return new ResponseUtil(200,"Vehicle Successfully Updated",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchVehicle(@PathVariable String id) {
        VehicleDTO vehicleDTO = vehicleService.searchVehicle(id);
        return new ResponseUtil(200,"Found",vehicleDTO);
    }
}
