package lk.ijse.easy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
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
    @OneToMany(cascade = CascadeType.ALL)
    private RentDTO rent;
}
