package lk.ijse.easy.dto;

import lk.ijse.easy.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class CustomerDTO {
    private String id;
    private String nic;
    private Name name;
    private String licenseNo;
    private String address;
    private String contactNo;
    private String email;
    private UserDTO user;
}
