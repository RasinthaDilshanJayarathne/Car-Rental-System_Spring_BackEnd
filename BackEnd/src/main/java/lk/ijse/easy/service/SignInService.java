package lk.ijse.easy.service;

import lk.ijse.easy.dto.UserDTO;

public interface SignInService {
    UserDTO login(String userName,String password);
}
