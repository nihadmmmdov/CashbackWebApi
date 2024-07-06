package com.example.transactioncashback.Repository.cashback;

import com.example.transactioncashback.Entity.CashBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashBackRepository extends JpaRepository<CashBack, Long>{
}
