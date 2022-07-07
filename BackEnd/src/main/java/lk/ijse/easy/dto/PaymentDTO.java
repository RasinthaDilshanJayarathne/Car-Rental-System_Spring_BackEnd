package lk.ijse.easy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalTime paymentDate;
    private double amount;
    private String  paymentType;
    private RentDTO rent;
}
