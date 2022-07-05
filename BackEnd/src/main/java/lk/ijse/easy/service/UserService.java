package lk.ijse.easy.service;



import lk.ijse.easy.dto.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);
    void deleteUser(String id);
    void updateUser(UserDTO userDTO);
    UserDTO searchUser(String id);
    List<UserDTO> getAllUsers();
}
