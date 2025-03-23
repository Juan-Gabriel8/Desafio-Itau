package com.jgroup.desafioItau.infrastructure.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;
@Entity
public class TransactionModel {

    @NotNull
    private double valor;
    @NotNull
    private OffsetDateTime dataHora;

    public TransactionModel(double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;

    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
