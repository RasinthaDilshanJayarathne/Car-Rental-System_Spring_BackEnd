package lk.ijse.easy.service;

import lk.ijse.easy.dto.FileDTO;
import lk.ijse.easy.enums.ReferencedType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface FileService {

    ResponseEntity<?> store(FileDTO fileDTO) throws IOException, Exception;

    byte[] getFile(String referencedId, ReferencedType referencedType) throws IOException;
}
