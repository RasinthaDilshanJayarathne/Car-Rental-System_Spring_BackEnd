package lk.ijse.easy.service;



import lk.ijse.easy.dto.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    void deleteUser(String name);
    void updateUser(UserDTO userDTO);
    UserDTO searchUser(String name);
    List<UserDTO> getAllUsers();
}
