package lk.ijse.easy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class PaymentDTO {
    private String paymentId;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate paymentDate;
    private double amount;
    private String  paymentType;
    private RentDTO rent;

    public PaymentDTO(LocalDate paymentDate, double amount, String paymentType, RentDTO rent) {
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentType = paymentType;
        this.rent = rent;
    }
}
