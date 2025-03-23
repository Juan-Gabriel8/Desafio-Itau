package com.jgroup.desafioItau.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@NotNull
public record CreateTransactionRequest(double valor) {
}
