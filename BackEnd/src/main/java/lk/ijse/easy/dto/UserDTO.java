package lk.ijse.easy.dto;

import lk.ijse.easy.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class UserDTO {
    private int userId;
    private String userName;
    private String password;
    private Role role;

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
