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
@Data
@Entity
public class Admin {
    @Id
    private String adminId;
    private String adminNic;
    @Embedded
    private Name adminName;
    private String customerLicenseNo;
    private String adminEmail;
    private String adminContactNo;
}
