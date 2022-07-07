package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.PaymentDTO;
import lk.ijse.easy.entity.Payment;
import lk.ijse.easy.entity.Rent;
import lk.ijse.easy.exception.DuplicateException;
import lk.ijse.easy.repo.PaymentRepo;
import lk.ijse.easy.service.PaymentService;
import org.modelmapper.ModelMapper;
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
    ModelMapper modelMapper;

    @Override
    public void savePayment(PaymentDTO paymentDTO) {
        if (!paymentRepo.existsById(paymentDTO.getPaymentId())) {
            Payment map = modelMapper.map(paymentDTO, Payment.class);
            paymentRepo.save(map);
        } else {
            throw new DuplicateException("Booking Already Exist..!");
        }
    }

    @Override
    public void deletePayment(String id) {

    }

    @Override
    public void updatePayment(PaymentDTO paymentDTO) {

    }

    @Override
    public PaymentDTO searchPayment(String id) {
        return null;
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return null;
    }
}
