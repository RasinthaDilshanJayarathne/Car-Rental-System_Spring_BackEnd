package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin,String> {

    @Query(value = "SELECT adminId FROM admin ORDER BY adminId DESC LIMIT 1", nativeQuery = true)
    String generateAdminId();
}
