package lk.ijse.easy.entity;

import lk.ijse.easy.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Data
public class User {
    @Id
    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
