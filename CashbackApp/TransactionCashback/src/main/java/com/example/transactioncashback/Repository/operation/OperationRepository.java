package com.example.transactioncashback.Repository.operation;

import com.example.transactioncashback.Entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    @Query("select o from Operation o where o.id=:id")
    Operation getById(@Param("id") Long id);
}
