package com.seerbit.assessment.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TransactionRequest {
    @NotNull(message = "timestamp is required")
    private Long timestamp;
    @NotNull(message = "amount is required")
    private Double amount;
}
