package az.edu.orient.dto;


import az.edu.orient.type.Currency;
import az.edu.orient.type.Status;
import az.edu.orient.validation.ValidAccountName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {
    private Long id;
    private String iban;
    @ValidAccountName(required = true)
    private String name;
    @NotNull(message = "Currency is required")
    private Currency currency;
    @NotNull(message = "balance is required")
    @PositiveOrZero(message = "Balance could not be less than 0")
    private BigDecimal balance;
    private Status status;
    private int userId;
}
