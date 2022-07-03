package lk.ijse.easy.entity;

import lk.ijse.easy.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Data
public class Customer {
    @Id
    private String customerId;
    private String customerNic;
    @Embedded
    private Name customerName;
    private String customerLicenseNo;
    private String customerAddress;
    private String customerContactNo;
    private String customerEmail;
}
