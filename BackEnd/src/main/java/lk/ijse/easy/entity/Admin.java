package lk.ijse.easy.entity;

import lk.ijse.easy.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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
    private String adminLicenseNo;
    private String adminEmail;
    private String adminContactNo;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
