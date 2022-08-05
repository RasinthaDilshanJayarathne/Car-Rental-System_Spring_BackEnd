package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.CustomerDTO;
import lk.ijse.easy.entity.Admin;
import lk.ijse.easy.entity.Customer;
import lk.ijse.easy.entity.User;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.exception.NotFoundException;
import lk.ijse.easy.repo.CustomerRepo;
import lk.ijse.easy.repo.UserRepo;
import lk.ijse.easy.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getId())) {
            if (!userRepo.existsByUserName(customerDTO.getUser().getUserName())){
                Customer map = modelMapper.map(customerDTO, Customer.class);
                customerRepo.save(map);
            }else {
                throw new DuplicateException("User Already Exist..!");
            }

        } else {
            throw new DuplicateException("Customer Already Exist..!");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else{
            throw new NotFoundException("Please check the Customer ID.. No Such Customer..!");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getId())){
            Customer map = modelMapper.map(customerDTO, Customer.class);
            customerRepo.save(map);
        }else {
            throw new NotFoundException("No Such a Customer..!");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (customerRepo.existsById(id)){
            Customer customer = customerRepo.findById(id).get();
            return modelMapper.map(customer, CustomerDTO.class);
        }else{
            throw new NotFoundException("No Customer For "+ id +" ..!");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        if (!customerRepo.findAll().isEmpty()){
            return modelMapper.map(customerRepo.findAll(), new TypeToken<List<CustomerDTO>>() {}.getType());
        }else {
            throw new NotFoundException("No Customers in database..!");
        }
    }

    @Override
    public int countCustomer() {
        return customerRepo.countCustomer();
    }

    @Override
    public String generateCustomerIds() {
        String id = customerRepo.generateCustomerIds();
        if (id != null) {
            int tempId = Integer.
                    parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                return "C00-00" + tempId;
            } else if (tempId <= 99) {
                return "C00-0" + tempId;
            } else {
                return "C00-" + tempId;
            }
        } else {
            return "C00-001";
        }
    }

    @Override
    public CustomerDTO searchCustomerByUserName(String userName) {
        if (userRepo.existsByUserName(userName)) {
            User byId = userRepo.findByUserName(userName);
            return modelMapper.map(customerRepo.findByUser(byId), CustomerDTO.class);
        }else {
            throw new NotFoundException("Customer Not Found");
        }
    }
}
