package az.edu.orient.entity;

import az.edu.orient.type.Currency;
import az.edu.orient.type.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.val;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String iban;
    private String name;
    private Currency currency;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private Status status;
    private int userId;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
