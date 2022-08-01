package lk.ijse.easy.controller;

import lk.ijse.easy.dto.CustomerDTO;
import lk.ijse.easy.service.CustomerService;
import lk.ijse.easy.util.FileUploadUtil;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    private FileUploadUtil fileUploadUtil;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers(){
        return new ResponseUtil(200,"Customer Successfully Loaded",customerService.getAllCustomers());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO customer){
        customerService.saveCustomer(customer);
        return new ResponseUtil(200,"Customer Successfully Saved",null);

    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
        return new ResponseUtil(200,"Customer Successfully Deleted",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customer){
        customerService.updateCustomer(customer);
        return new ResponseUtil(200,"Customer Successfully Updated",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String id) {
        CustomerDTO customerDTO = customerService.searchCustomer(id);
        return new ResponseUtil(200,"Found",customerDTO);
    }

    @GetMapping(path ="/COUNT/{count}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil countCustomers(@PathVariable String count){
        return new ResponseUtil(200, "Ök", customerService.countCustomer());
    }

//    @PostMapping(path = "addPersonalImage", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseUtil addPersonalImage(@RequestParam(value = "param") MultipartFile[] multipartFile, @RequestParam("id") String id) {
//        String pathDirectory = "E:\\GDSE58-2nd_Sem\\Spring\\Car-Rental-System_BackEnd\\BackEnd\\src\\main\\resources\\licenceImage";
//        String[] personalImageView = {"Nic", "License"};
//
//        for (int i = 0; i < multipartFile.length; i++) {
//            String[] split = multipartFile[i].getContentType().split("/");
//            if (split[1].equals("jpeg") || split[1].equals("png")) {
//                String imageName = id + personalImageView[i] + ".jpeg";
//                fileUploadUtil.saveFile(pathDirectory+imageName , multipartFile[i]);
//
//            } else {
//                return new ResponseUtil(404, "please..  must be images type  jpeg or png", null);
//            }
//        }
//        return new ResponseUtil(200, "Images added complete", null);
//    }
}
