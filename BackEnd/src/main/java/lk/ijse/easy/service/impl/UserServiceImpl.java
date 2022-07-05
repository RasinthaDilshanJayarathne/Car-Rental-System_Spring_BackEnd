package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.UserDTO;
import lk.ijse.easy.entity.Driver;
import lk.ijse.easy.entity.User;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.repo.UserRepo;
import lk.ijse.easy.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveUser(UserDTO userDTO) {
        if (!userRepo.existsById(userDTO.getUserName())) {
            User map = modelMapper.map(userDTO, User.class);
            userRepo.save(map);
            System.out.println(userDTO.getUserName());
        } else {
            throw new DuplicateException("User Already Exist..!");
        }
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public void updateUser(UserDTO userDTO) {

    }

    @Override
    public UserDTO searchUser(String id) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }
}
