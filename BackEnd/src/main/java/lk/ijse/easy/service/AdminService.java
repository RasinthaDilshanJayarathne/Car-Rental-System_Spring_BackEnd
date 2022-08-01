package lk.ijse.easy.service;

import lk.ijse.easy.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    void saveAdmin(AdminDTO adminDTO);
    void deleteAdmin(String id);
    void updateAdmin(AdminDTO adminDTO);
    AdminDTO searchAdmin(String id);
    List<AdminDTO>getAllAdmins();
    String generateAdminIds();
}
