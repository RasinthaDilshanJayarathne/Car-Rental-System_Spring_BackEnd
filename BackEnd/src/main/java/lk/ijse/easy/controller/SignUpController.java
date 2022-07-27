package lk.ijse.easy.controller;

import lk.ijse.easy.dto.CustomerDTO;
import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.service.SignUpService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("signup")
@CrossOrigin
public class SignUpController {
    @Autowired
    SignUpService signUpService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/driver")
    public ResponseUtil saveDriver(@RequestBody DriverDTO driverDTO){
        signUpService.saveDriver(driverDTO);
        return new ResponseUtil(200,"Saved",null);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/customer")
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO customerDTO){
        signUpService.saveCustomer(customerDTO);
        return new ResponseUtil(200,"Saved",null);
    }
}
