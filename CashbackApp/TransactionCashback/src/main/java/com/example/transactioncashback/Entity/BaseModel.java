package com.example.transactioncashback.Entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseModel {
    private LocalDateTime createdDate;
    private Boolean active;
}
