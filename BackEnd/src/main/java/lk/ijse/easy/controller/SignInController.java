package lk.ijse.easy.controller;

import lk.ijse.easy.dto.UserDTO;
import lk.ijse.easy.service.SignInService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("signin")
@CrossOrigin
public class SignInController {
    @Autowired
    SignInService signInService;

    @GetMapping(params = {"userName","password"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil logging(@RequestParam String userName,@RequestParam String password){
        UserDTO userDto = signInService.login(userName,password);
        return new ResponseUtil(200,"OK",userDto);
    }
}
