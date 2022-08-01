package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.AdminDTO;
import lk.ijse.easy.dto.CustomerDTO;
import lk.ijse.easy.entity.Admin;
import lk.ijse.easy.entity.Customer;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.exception.NotFoundException;
import lk.ijse.easy.repo.AdminRepo;
import lk.ijse.easy.repo.UserRepo;
import lk.ijse.easy.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveAdmin(AdminDTO adminDTO) {
        if (!adminRepo.existsById(adminDTO.getAdminId())) {
            if (!userRepo.existsByUserName(adminDTO.getUser().getUserName())){
                Admin map = modelMapper.map(adminDTO, Admin.class);
                adminRepo.save(map);
            }else {
                throw new DuplicateException("User Already Exist..!");
            }

        } else {
            throw new DuplicateException("Admin Already Exist..!");
        }
    }

    @Override
    public void deleteAdmin(String id) {
        if (adminRepo.existsById(id)){
            adminRepo.deleteById(id);
        }else{
            throw new NotFoundException("Please check the Admin ID.. No Such Admin..!");
        }
    }

    @Override
    public void updateAdmin(AdminDTO adminDTO) {
        if (adminRepo.existsById(adminDTO.getAdminId())){
            Admin map = modelMapper.map(adminDTO, Admin.class);
            adminRepo.save(map);
        }else {
            throw new NotFoundException("No Such a Admin..!");
        }
    }

    @Override
    public AdminDTO searchAdmin(String id) {
        if (adminRepo.existsById(id)){
            Admin admin = adminRepo.findById(id).get();
            return modelMapper.map(admin, AdminDTO.class);
        }else{
            throw new NotFoundException("No Admin For "+ id +" ..!");
        }
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        if (!adminRepo.findAll().isEmpty()){
            return modelMapper.map(adminRepo.findAll(), new TypeToken<List<AdminDTO>>() {}.getType());
        }else {
            throw new NotFoundException("No Admins in database..!");
        }
    }

    @Override
    public String generateAdminIds() {
        String id = adminRepo.generateAdminId();
        if (id != null) {
            int tempId = Integer.
                    parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                return "A00-00" + tempId;
            } else if (tempId <= 99) {
                return "A00-0" + tempId;
            } else {
                return "A00-" + tempId;
            }
        } else {
            return "A00-001";
        }
    }
}
