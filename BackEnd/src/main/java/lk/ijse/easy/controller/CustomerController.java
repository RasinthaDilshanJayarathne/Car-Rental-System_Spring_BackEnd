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

    @GetMapping(params = {"test"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateCustomerIds(@RequestParam String test) {
        return new ResponseUtil(200, "Ok", customerService.generateCustomerIds());
    }

}
