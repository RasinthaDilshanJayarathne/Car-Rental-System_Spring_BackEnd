package lk.ijse.easy.controller;

import lk.ijse.easy.dto.CustomerDTO;
import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.service.SignUpService;
import lk.ijse.easy.util.FileUploadUtil;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("signup")
@CrossOrigin
public class SignUpController {
    @Autowired
    SignUpService signUpService;

    @Autowired
    private FileUploadUtil fileUploadUtil;

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

    @PostMapping(path = "addPersonalImage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil addPersonalImage(@RequestParam(value = "param") MultipartFile[] multipartFile, @RequestParam("id") String id) {
        String pathDirectory = "E:\\GDSE58-2nd_Sem\\Spring\\Car-Rental-System_BackEnd\\BackEnd\\src\\main\\resources\\static\\Image\\carImage\\";
        String[] personalImageView = {"Nic", "License"};

        for (int i = 0; i < multipartFile.length; i++) {
            String[] split = multipartFile[i].getContentType().split("/");
            if (split[1].equals("jpeg") || split[1].equals("png")) {
                String imageName = id + personalImageView[i] + ".jpeg";
                fileUploadUtil.saveFile(pathDirectory+imageName , multipartFile[i]);

            } else {
                return new ResponseUtil(404, "please..  must be images type  jpeg or png", null);
            }
        }
        return new ResponseUtil(200, "Images added complete", null);
    }
}
