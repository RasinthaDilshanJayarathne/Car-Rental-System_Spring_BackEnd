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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil logging(@RequestBody UserDTO userDTO){
        UserDTO userDto = signInService.login(userDTO);
        return new ResponseUtil(200,"OK",userDto);
    }
}
