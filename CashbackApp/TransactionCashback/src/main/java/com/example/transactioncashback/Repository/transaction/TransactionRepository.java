package com.example.transactioncashback.Repository.transaction;

import com.example.transactioncashback.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("select t from Transaction t where t.id=:id")
    Transaction getById(@Param("id") Long id);
}
