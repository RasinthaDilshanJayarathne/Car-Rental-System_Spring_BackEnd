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
@Entity
@Data
public class Customer {
    @Id
    private String id;
    private String nic;
    @Embedded
    private Name name;
    private String licenseNo;
    private String address;
    private String contactNo;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
