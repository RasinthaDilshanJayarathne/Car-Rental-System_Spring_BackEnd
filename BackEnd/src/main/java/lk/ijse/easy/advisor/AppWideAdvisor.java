package lk.ijse.easy.advisor;

import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.exception.NotFoundException;
import lk.ijse.easy.exception.TableLoadException;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideAdvisor {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseUtil> exceptionHandler(Exception e) {
        return new ResponseEntity<>(new ResponseUtil(500, "Error",e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ResponseUtil> duplicateEntryException(Exception e) {
        return new ResponseEntity<>(new ResponseUtil(500, "Error",e.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseUtil> notFoundException(Exception e) {
        return new ResponseEntity<>(new ResponseUtil(500, "Error",e.getMessage()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TableLoadException.class)
    public ResponseEntity<ResponseUtil> tableLoadException(Exception e) {
        return new ResponseEntity<>(new ResponseUtil(200, "Load",e.getMessage()),HttpStatus.OK);
    }

}
