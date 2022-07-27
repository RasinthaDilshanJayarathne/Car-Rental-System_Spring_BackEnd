package lk.ijse.easy.controller;

import lk.ijse.easy.service.SearchService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("search")
@CrossOrigin
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping(params = {"pickupDate","returnDate"})
    public ResponseUtil loadAvailableVehicles(@RequestParam String pickupDate, @RequestParam String returnDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate pickUp = LocalDate.parse(pickupDate);
        LocalDate dropOff = LocalDate.parse(returnDate, formatter);
        return new ResponseUtil(200,"OK", searchService.loadAvailableVehicles(pickUp,dropOff));
    }
}
