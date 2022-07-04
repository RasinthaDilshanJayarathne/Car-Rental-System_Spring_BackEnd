package lk.ijse.easy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
//@Entity
public class Payment {
    @Id
    @GeneratedValue
    private String paymentId;
    private LocalTime paymentDate;
}
