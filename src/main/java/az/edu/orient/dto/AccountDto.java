package az.edu.orient.dto;


import az.edu.orient.type.Currency;
import az.edu.orient.type.Status;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {
    private Long id;
    private String iban;
    private String name;
    private Currency currency;
    private BigDecimal balance;
    private Status status;
}
