package lk.ijse.easy.controller;

import lk.ijse.easy.dto.AdminDTO;
import lk.ijse.easy.dto.RentDTO;
import lk.ijse.easy.service.RentService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rent")
@CrossOrigin
public class RentController {

    @Autowired
    RentService rentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRents(){
        return new ResponseUtil(200,"Successfully Loaded",rentService.getAllRents());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveRent(@RequestBody RentDTO rent){
        rentService.saveRent(rent);
        return new ResponseUtil(200,"Saved",null);

    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteRent(@RequestParam String id) {
        rentService.deleteRent(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateRent(@RequestBody RentDTO rent){
        rentService.updateRent(rent);
        return new ResponseUtil(200,"Updated",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRent(@PathVariable String id) {
        RentDTO rentDTO = rentService.searchRent(id);
        return new ResponseUtil(200,"Found",rentDTO);
    }
}
