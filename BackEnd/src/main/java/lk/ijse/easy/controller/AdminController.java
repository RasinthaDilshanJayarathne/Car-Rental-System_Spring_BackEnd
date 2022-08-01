package lk.ijse.easy.controller;

import lk.ijse.easy.dto.AdminDTO;
import lk.ijse.easy.dto.CustomerDTO;
import lk.ijse.easy.repo.AdminRepo;
import lk.ijse.easy.service.AdminService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService adminService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllAdmins(){
        return new ResponseUtil(200,"Admin Successfully Loaded",adminService.getAllAdmins());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAdmin(@RequestBody AdminDTO admin){
        adminService.saveAdmin(admin);
        return new ResponseUtil(200,"Admin Successfully Saved",null);

    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteAdmin(@RequestParam String id) {
        adminService.deleteAdmin(id);
        return new ResponseUtil(200,"Admin Successfully Deleted",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateAdmin(@RequestBody AdminDTO admin){
        adminService.updateAdmin(admin);
        return new ResponseUtil(200,"Admin Successfully Updated",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchAdmin(@PathVariable String id) {
        AdminDTO adminDTO = adminService.searchAdmin(id);
        return new ResponseUtil(200,"Found",adminDTO);
    }

    @GetMapping(params = {"test"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateAdminIds(@RequestParam String test) {
        return new ResponseUtil(200, "Ok", adminService.generateAdminIds());
    }
}
