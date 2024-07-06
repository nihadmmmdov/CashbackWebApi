package com.example.transactioncashback.Service.cashback;

import com.example.transactioncashback.Dto.TransactionRequest;
import com.example.transactioncashback.Entity.CashBack;
import com.example.transactioncashback.Entity.Transaction;
import com.example.transactioncashback.Entity.User;
import com.example.transactioncashback.Repository.cashback.CashBackRepository;
import com.example.transactioncashback.Repository.transaction.TransactionRepository;
import com.example.transactioncashback.Repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
public class CashBackService {
    private final UserRepository userRepository;
    private final CashBackRepository cashBackRepository;
    private final TransactionRepository transactionRepository;
    private static final double CASHBACK_PERCENTAGE = 0.03; // 3% cashback

    public void processTransaction(TransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setUserId(request.getUserId());
        transaction.setAmount(request.getAmount());
        transactionRepository.save(transaction);
        applyCashback(request);
    }

    private void applyCashback(TransactionRequest transaction) {
        double cashbackAmount = transaction.getAmount() * CASHBACK_PERCENTAGE;
        CashBack cashback = new CashBack();
        cashback.setUserId(transaction.getUserId());
        cashback.setAmount(cashbackAmount);
        cashback.setCashbackDate(LocalDateTime.now());
        cashBackRepository.save(cashback);

        User user = userRepository.findById(transaction.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        user.setCashbackBalance(user.getCashbackBalance() + cashbackAmount);
        userRepository.save(user);
    }
}
