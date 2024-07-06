package com.example.transactioncashback.Controller;

import com.example.transactioncashback.Dto.TransactionRequest;
import com.example.transactioncashback.Service.cashback.CashBackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cashback")
public class CashBackController {
    private final CashBackService cashBackService;
    @PostMapping("/transaction")
    public ResponseEntity<String> processTransaction(@RequestBody TransactionRequest request) {
        cashBackService.processTransaction(request);
        return ResponseEntity.ok("Transaction processed and cashback applied.");
    }
}
