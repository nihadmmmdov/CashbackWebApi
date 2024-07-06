package com.example.transactioncashback.Repository.card;

import com.example.transactioncashback.Entity.Card;
import com.example.transactioncashback.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByCardNumber(String cardNumber);
    @Query("select c from Card c where c.id=:id")
    Card getById(@Param("id") Long id);
}
