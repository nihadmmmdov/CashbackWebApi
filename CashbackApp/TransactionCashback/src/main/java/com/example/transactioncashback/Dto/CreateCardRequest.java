package com.example.transactioncashback.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCardRequest {
    private String cardNumber;
    private String cardHolderName;
    private BigDecimal balance;
}
