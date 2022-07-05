package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.AdminDTO;
import lk.ijse.easy.entity.Admin;
import lk.ijse.easy.entity.Customer;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.repo.AdminRepo;
import lk.ijse.easy.service.AdminService;
import org.modelmapper.ModelMapper;
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
    ModelMapper modelMapper;

    @Override
    public void saveAdmin(AdminDTO adminDTO) {
        if (!adminRepo.existsById(adminDTO.getAdminId())) {
            Admin map = modelMapper.map(adminDTO, Admin.class);
            adminRepo.save(map);
            System.out.println(adminDTO.getAdminId());
        } else {
            throw new DuplicateException("Admin Already Exist..!");
        }
    }

    @Override
    public void deleteAdmin(String id) {

    }

    @Override
    public void updateAdmin(AdminDTO adminDTO) {

    }

    @Override
    public AdminDTO searchAdmin(String id) {
        return null;
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        return null;
    }
}
