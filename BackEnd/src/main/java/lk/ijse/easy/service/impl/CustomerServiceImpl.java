package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.CustomerDTO;
import lk.ijse.easy.entity.Customer;
import lk.ijse.easy.repo.CustomerRepo;
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
    private ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getCustomerId())) {
            Customer map = modelMapper.map(customerDTO, Customer.class);
            customerRepo.save(map);
            System.out.println(customerDTO.getCustomerId());
        } else {
            throw new RuntimeException("Customer Already Exist..!");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else{
            throw new RuntimeException("Please check the Customer ID.. No Such Customer..!");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerId())){
            Customer map = modelMapper.map(customerDTO, Customer.class);
            customerRepo.save(map);
        }else {
            throw new RuntimeException("No Such a Customer..!");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (customerRepo.existsById(id)){
            Customer customer = customerRepo.findById(id).get();
            return modelMapper.map(customer, CustomerDTO.class);
        }else{
            throw new RuntimeException("No Customer For "+id+" ..!");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return modelMapper.map(customerRepo.findAll(), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }
}
