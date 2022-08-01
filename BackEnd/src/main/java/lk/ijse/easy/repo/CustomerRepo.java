package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer,String> {
    @Query(value = "SELECT COUNT(*) FROM customer", nativeQuery = true)
    int countCustomer();
}
