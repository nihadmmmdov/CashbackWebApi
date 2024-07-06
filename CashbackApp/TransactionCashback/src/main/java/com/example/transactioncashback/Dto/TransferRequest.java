package com.example.transactioncashback.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequest {
    private String fromCardNumber;
    private String toCardNumber;
    private BigDecimal amount;
}
