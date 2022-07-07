package lk.ijse.easy.entity;

import lk.ijse.easy.enums.Role;
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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String userName, String password, Role role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
}
