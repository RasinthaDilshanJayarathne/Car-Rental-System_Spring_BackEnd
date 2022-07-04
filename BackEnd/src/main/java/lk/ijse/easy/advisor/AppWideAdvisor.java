package lk.ijse.easy.advisor;

import lk.ijse.easy.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AppWideAdvisor {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ResponseUtil> exceptionHandler(Exception e) {
        return new ResponseEntity<>(new ResponseUtil(500, "Error",e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
