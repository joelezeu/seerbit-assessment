package com.seerbit.assessment.utils;

import com.seerbit.assessment.domain.TransactionRequest;
import com.seerbit.assessment.exception.TransactionTimeException;

import java.time.Instant;

public class Utils {

    public static final Integer seconds = 60000;//Time in 30secs

    public boolean validateTimeDiff(TransactionRequest transactionRequest) {
        if (Instant.now().toEpochMilli() < transactionRequest.getTimestamp().toEpochMilli()) {
            throw new TransactionTimeException();
        }
        if ((Instant.now().toEpochMilli() - transactionRequest.getTimestamp().toEpochMilli()) < seconds
                && Instant.now().toEpochMilli() >= transactionRequest.getTimestamp().toEpochMilli()) {
            return true;
        }
        return false;
    }
}
