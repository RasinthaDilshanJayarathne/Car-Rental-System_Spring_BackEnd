package lk.ijse.easy.repo;

import lk.ijse.easy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
