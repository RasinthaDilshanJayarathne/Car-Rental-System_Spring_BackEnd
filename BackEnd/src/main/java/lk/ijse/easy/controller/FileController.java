package lk.ijse.easy.controller;

import lk.ijse.easy.dto.FileDTO;
import lk.ijse.easy.enums.ReferencedType;
import lk.ijse.easy.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("upload")
@CrossOrigin
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping(produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity saveFile(FileDTO fileDTO) throws Exception {
        return fileService.store(fileDTO);
    }

    @GetMapping("/{referencedId}/{referencedType}")
    public ResponseEntity getAllImagesFromDatabase(@PathVariable String referencedId, @PathVariable ReferencedType referencedType) throws IOException, IOException {
        byte[] file = fileService.getFile(referencedId, referencedType);
        return ResponseEntity.ok(file);
    }

}
