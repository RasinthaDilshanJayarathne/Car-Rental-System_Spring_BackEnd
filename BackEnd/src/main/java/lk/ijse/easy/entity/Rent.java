package lk.ijse.easy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.ijse.easy.enums.RequestingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class Rent {
    @Id
    private String rentId;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private LocalDate returnDate;
    @Enumerated(EnumType.STRING)
    private RequestingType driverRequestingType;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "customerID",referencedColumnName = "customerId",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "rent",cascade = CascadeType.ALL)
    private List<DriverSchedule> driverSchedules;

    @OneToMany(mappedBy = "rent",cascade = CascadeType.ALL)
    private List<RentDetails> rentDetails;
}
