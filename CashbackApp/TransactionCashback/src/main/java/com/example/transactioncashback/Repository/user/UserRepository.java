package com.example.transactioncashback.Repository.user;

import com.example.transactioncashback.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.active=true and u.name=:name")
    User getByName(@Param("name") String name);
    @Query("select u from User u where u.active=true and u.id=:id")
    User getById(@Param("id") Long id);
}
