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
    private String customerId;
    private String customerNic;
    private Name customerName;
    private String customerLicenseNo;
    private String customerAddress;
    private String customerContactNo;
    private String customerEmail;
}
