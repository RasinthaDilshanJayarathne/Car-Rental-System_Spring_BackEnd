package lk.ijse.easy.entity;

import lk.ijse.easy.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Data
public class Customer {
    @Id
    private String cusId;
    private String nic;
    private Name name;
    private String licenseNo;
    private String address;
    private String contactNo;
    private String email;
}
