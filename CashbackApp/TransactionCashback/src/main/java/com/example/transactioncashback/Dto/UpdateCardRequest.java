package com.example.transactioncashback.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCardRequest {
    private Long id;
    private String cardNumber;
    private String cardHolderName;
}
