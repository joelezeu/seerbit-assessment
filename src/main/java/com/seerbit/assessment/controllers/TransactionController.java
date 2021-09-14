package com.seerbit.assessment.controllers;

import com.seerbit.assessment.domain.TransactionRequest;
import com.seerbit.assessment.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/transaction")
    public ResponseEntity<?> createTransaction(@RequestBody @Valid TransactionRequest transactionRequest) {
        return transactionService.createTransaction(transactionRequest);
    }
}
