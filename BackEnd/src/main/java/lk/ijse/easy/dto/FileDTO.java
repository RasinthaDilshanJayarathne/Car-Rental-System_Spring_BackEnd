package lk.ijse.easy.dto;

import lk.ijse.easy.enums.ReferencedType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class FileDTO {
    private String referencedId;
    private MultipartFile uploadFile;
    private ReferencedType fileCategory;
}
