package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.dto.PaymentDTO;
import lk.ijse.easy.entity.Driver;
import lk.ijse.easy.entity.Payment;
import lk.ijse.easy.entity.Rent;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.exception.NotFoundException;
import lk.ijse.easy.repo.PaymentRepo;
import lk.ijse.easy.repo.RentRepo;
import lk.ijse.easy.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    RentRepo rentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void savePayment(PaymentDTO paymentDTO) {
        if (!paymentRepo.existsById(paymentDTO.getPaymentId())) {
            if(rentRepo.existsById(paymentDTO.getRent().getRentId())){
                Payment map = modelMapper.map(paymentDTO, Payment.class);
                paymentRepo.save(map);
            }else {
                throw new DuplicateException("Booking Already Exist..!");
            }
        } else {
            throw new DuplicateException("Payment Already Exist..!");
        }
    }

    @Override
    public void deletePayment(String id) {
        if (paymentRepo.existsById(id)){
            paymentRepo.deleteById(id);
        }else{
            throw new NotFoundException("Please check the Payment ID.. No Such Payment..!");
        }
    }

    @Override
    public void updatePayment(PaymentDTO paymentDTO) {
        if (paymentRepo.existsById(paymentDTO.getPaymentId())){
            Payment map = modelMapper.map(paymentDTO, Payment.class);
            paymentRepo.save(map);
        }else {
            throw new NotFoundException("No Such a Payment..!");
        }
    }

    @Override
    public PaymentDTO searchPayment(String id) {
        if (paymentRepo.existsById(id)){
            Payment payment = paymentRepo.findById(id).get();
            return modelMapper.map(payment, PaymentDTO.class);
        }else{
            throw new NotFoundException("No Payment For "+ id +" ..!");
        }
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        if (!paymentRepo.findAll().isEmpty()){
            return modelMapper.map(paymentRepo.findAll(), new TypeToken<List<PaymentDTO>>() {}.getType());
        }else {
            throw new NotFoundException("No Payments in database..!");
        }
    }
}
