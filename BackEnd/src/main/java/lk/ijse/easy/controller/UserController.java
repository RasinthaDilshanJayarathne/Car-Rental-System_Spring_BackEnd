package lk.ijse.easy.controller;

import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.dto.UserDTO;
import lk.ijse.easy.service.UserService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllUsers(){
        return new ResponseUtil(200,"Successfully Loaded",userService.getAllUsers());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveUser(@RequestBody UserDTO user){
        userService.saveUser(user);
        return new ResponseUtil(200,"Saved",null);
    }

    @DeleteMapping(params = {"name"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
        return new ResponseUtil(200,"Deleted",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateUser(@RequestBody UserDTO user){
        userService.updateUser(user);
        return new ResponseUtil(200,"Updated",null);
    }

    @GetMapping(path = "/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchUser(@PathVariable String name) {
        UserDTO userDTO = userService.searchUser(name);
        return new ResponseUtil(200,"Found",userDTO);
    }
}
