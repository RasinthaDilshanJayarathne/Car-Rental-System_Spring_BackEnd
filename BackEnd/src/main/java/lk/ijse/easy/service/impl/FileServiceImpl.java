package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.FileDTO;
import lk.ijse.easy.entity.File;
import lk.ijse.easy.enums.ReferencedType;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.repo.FileRepo;
import lk.ijse.easy.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Transactional
public class FileServiceImpl implements FileService {

    private String fileUpload= "uploads";

    @Autowired
    FileRepo fileRepo;

    @Override
    public ResponseEntity<?> store(FileDTO fileDTO) throws IOException, Exception {
        if (fileDTO.getFileCategory().equals(ReferencedType.NIC)||fileDTO.getFileCategory().equals(ReferencedType.DRIVING_LICEN_NO)){
            if (fileRepo.existsByReferencedIdAndReferencedType(fileDTO.getReferencedId(), fileDTO.getFileCategory()))
                throw new DuplicateException("File Already Exists");
        }
        String dirName = "E://GDSE58-2nd_Sem/Spring/uploads/";
        String fileName = UUID.randomUUID() + "." + StringUtils.getFilenameExtension(fileDTO.getUploadFile().getOriginalFilename());
        java.io.File uploadsDir = new java.io.File( dirName);
        if (!uploadsDir.exists())
            uploadsDir.mkdir();
        String filePath = dirName.concat(fileName);

        Path path = Paths.get(filePath);
        byte[] fi = fileDTO.getUploadFile().getBytes();
        Files.write(path,fi);

        File file = new File(fileDTO.getReferencedId(), fileDTO.getFileCategory(), filePath);
        fileRepo.save(file);

        return ResponseEntity.ok().build();
    }

    @Override
    public byte[] getFile(String referencedId, ReferencedType referencedType) throws IOException {
        File file = fileRepo.findByReferencedIdAndReferencedType(referencedId, referencedType);
        if (file == null) {
            throw new DuplicateException("Not Such a File");
        }
        java.io.File file1 = new java.io.File(file.getFilePath());
        FileInputStream fileInputStream = new FileInputStream(file1);
        return StreamUtils.copyToByteArray(fileInputStream);
    }
}
