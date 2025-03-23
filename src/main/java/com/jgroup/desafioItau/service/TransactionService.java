package com.jgroup.desafioItau.service;

import com.jgroup.desafioItau.dto.CreateTransactionRequest;
import com.jgroup.desafioItau.infrastructure.exceptions.BusinessException;
import com.jgroup.desafioItau.infrastructure.mapper.TransactionMapper;
import com.jgroup.desafioItau.infrastructure.model.TransactionModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    private final List<TransactionModel> transactions = new ArrayList<>();
    private final TransactionMapper transactionMapper;

    public TransactionService(TransactionMapper transactionMapper) {
        this.transactionMapper = transactionMapper;
    }

    public TransactionModel createTransaction(CreateTransactionRequest transactionRequest) {
        validateTransaction(transactionRequest);
        TransactionModel transaction = transactionMapper.toEntity(transactionRequest);
        transactions.add(transaction);
        return transaction;
    }

    private void validateTransaction(CreateTransactionRequest transactionDTO) {

        if (transactionDTO.valor() < 0) {
            throw new BusinessException("O valor da transação não pode ser negativo.");
        }
    }
}
