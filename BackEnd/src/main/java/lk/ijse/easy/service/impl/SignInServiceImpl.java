package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.UserDTO;
import lk.ijse.easy.entity.User;
import lk.ijse.easy.exception.NotFoundException;
import lk.ijse.easy.repo.UserRepo;
import lk.ijse.easy.service.SignInService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDTO login(String userName,String password) {
        User user = userRepo.findByUserName(userName);

        if (user!=null){
            if (user.getPassword().equals(password)){
                return modelMapper.map(user,UserDTO.class);
            }else {
                throw new RuntimeException("Incorrect Password");
            }
        }else {
            throw new NotFoundException("User Not Fond");
        }
    }
}
