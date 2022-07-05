package lk.ijse.easy.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class PaymentDTO {
    private String paymentId;
    private LocalTime paymentDate;
    private double amount;
    private String  paymentType;
    private RentDTO rent;
}
