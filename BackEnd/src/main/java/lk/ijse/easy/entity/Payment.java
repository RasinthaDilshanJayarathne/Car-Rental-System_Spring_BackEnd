package lk.ijse.easy.entity;

import lk.ijse.easy.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class Payment {
    @Id
    private String paymentId;
    private LocalDate paymentDate;
    private double amount;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "rentId",referencedColumnName = "rentId",insertable = false,updatable = false)
    private Rent rent;

    public Payment(LocalDate paymentDate, double amount, PaymentType paymentType, Rent rent) {
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentType = paymentType;
        this.rent = rent;
    }
}
