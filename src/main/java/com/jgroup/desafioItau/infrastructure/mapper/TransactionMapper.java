package com.jgroup.desafioItau.infrastructure.mapper;

import com.jgroup.desafioItau.dto.CreateTransactionRequest;
import com.jgroup.desafioItau.infrastructure.model.TransactionModel;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class TransactionMapper {
    public TransactionModel toEntity(CreateTransactionRequest dto) {
        return new TransactionModel(dto.valor(), OffsetDateTime.now());
    }
}