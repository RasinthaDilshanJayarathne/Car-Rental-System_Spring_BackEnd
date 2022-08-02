package lk.ijse.easy.controller;

import lk.ijse.easy.dto.ImageDTO;
import lk.ijse.easy.dto.VehicleDTO;
import lk.ijse.easy.enums.VehicleType;
import lk.ijse.easy.service.VehicleService;
import lk.ijse.easy.util.FileDownloadUtil;
import lk.ijse.easy.util.FileSearchUtil;
import lk.ijse.easy.util.FileUploadUtil;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    private FileDownloadUtil fileDownloadUtil;

    @Autowired
    private FileSearchUtil searchFile;

    @Autowired
    private FileUploadUtil fileUploadUtil;

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

    @DeleteMapping(params = {"vehicleId"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteVehicle(@RequestParam String vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
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

    @GetMapping(path ="/COUNT/{count}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil countVehicle(@PathVariable String count){
        return new ResponseUtil(200, "Ök", vehicleService.countVehicle());
    }

    @GetMapping(params = {"test"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateVehicleIds(@RequestParam String test) {
        return new ResponseUtil(200, "Ok", vehicleService.generateVehicleIds());
    }

    @GetMapping(params = {"vehicleType"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllGeneralVehicle(@RequestParam VehicleType vehicleType) {
        List<VehicleDTO> allGeneralVehicles = vehicleService.getAllGeneralVehicles(vehicleType);
        return new ResponseUtil(200,"Found",allGeneralVehicles);
    }

    @PostMapping(path = "addCarImage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil addCarImage(@RequestParam(value = "param") MultipartFile[] multipartFile, @RequestParam("carId") String carId) {
        String pathDirectory = "E:\\GDSE58-2nd_Sem\\Spring\\Car-Rental-System_BackEnd\\BackEnd\\src\\main\\resources\\static\\Image\\carImage\\";
        String[] carImageView = {"Front", "Back", "Side"};

        for (int i = 0; i < multipartFile.length; i++) {
            String[] split = multipartFile[i].getContentType().split("/");
            if (split[1].equals("jpeg") || split[1].equals("png")) {
                String imageName = carId + carImageView[i] + ".jpeg";
                fileUploadUtil.saveFile(pathDirectory+imageName , multipartFile[i]);

            } else {
                return new ResponseUtil(404, "please..  must be Car images type  jpeg or png", null);
            }
        }
        return new ResponseUtil(200, "Car images added complete", null);
    }

    @GetMapping(path = "getCarImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> getCarImage(@RequestParam String carId, String view) {

        ImageDTO imageDto = new ImageDTO(carId, "car", view);
        Resource fileAsResource1 = fileDownloadUtil.getFileAsResource(imageDto);

        if (fileAsResource1==null){
            return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body("Car Image not found");
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(fileAsResource1);
    }

    @PostMapping(path = "updateCarImage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCarImage(@RequestParam(value = "carImage") MultipartFile multipartFile, @RequestParam("carId") String carId, @RequestParam("view") String view) throws IOException {

        String pathDirectory = "E:\\GDSE58-2nd_Sem\\Spring\\Car-Rental-System_BackEnd\\BackEnd\\src\\main\\resources\\static\\Image\\carImage\\";

        if (searchFile.searchFile(pathDirectory, carId + view + ".jpeg")) {
            Files.copy(multipartFile.getInputStream(), Paths.get(pathDirectory + File.separator + carId + view + ".jpeg"), StandardCopyOption.REPLACE_EXISTING);
            return new ResponseUtil(200, "car Image Updated", null);
        }
        return new ResponseUtil(200, "car Image Update Fail", null);
    }

    @DeleteMapping(path = "deleteCarImage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCarAllImages(@RequestParam String vehicleId) throws IOException {
        String pathDirectory = "E:\\GDSE58-2nd_Sem\\Spring\\Car-Rental-System_BackEnd\\BackEnd\\src\\main\\resources\\static\\Image\\carImage\\";
        String[] carImageView = {"Front", "Back", "Side"};

        for (int i = 0; i < carImageView.length; i++) {
            Files.deleteIfExists(Paths.get(pathDirectory + File.separator + vehicleId + carImageView[i] + ".jpeg"));
        }

        return new ResponseUtil(200, "car Delete success", null);
    }
}
