package lk.ijse.easy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ImageDTO {
    String imageId;
    String imageType;
    String imageView;
}
