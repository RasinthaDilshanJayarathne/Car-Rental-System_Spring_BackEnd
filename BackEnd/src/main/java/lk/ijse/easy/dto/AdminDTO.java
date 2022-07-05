package lk.ijse.easy.dto;

import lk.ijse.easy.embeded.Name;
import lk.ijse.easy.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class AdminDTO {
    private String adminId;
    private String adminNic;
    private Name adminName;
    private String adminLicenseNo;
    private String adminEmail;
    private String adminContactNo;
    private UserDTO user;
}
