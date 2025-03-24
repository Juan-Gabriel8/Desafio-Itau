package com.jgroup.desafioItau.controller;

import com.jgroup.desafioItau.dto.CreateTransactionRequest;
import com.jgroup.desafioItau.infrastructure.model.TransactionModel;
import com.jgroup.desafioItau.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody CreateTransactionRequest transactionDTO) {
        TransactionModel transaction = transactionService.createTransaction(transactionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTransactions() {
        transactionService.deleteTransaction();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
