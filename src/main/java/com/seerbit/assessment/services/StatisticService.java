package com.seerbit.assessment.services;

import com.seerbit.assessment.domain.Statistics;
import com.seerbit.assessment.utils.DBInstance;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

@Service
public class StatisticService {
    private Statistics calculateStats(long oldestAcceptableTxnTime) {
        ConcurrentMap<Long, Double> concurrentMap = DBInstance.getDBInstance();
        double min = 0, max = 0, sum = 0;
        long count = 0;
        for (Map.Entry<Long, Double> txn : concurrentMap.entrySet()) {
            if (txn.getValue() < oldestAcceptableTxnTime) {
                continue;
            }
            double amount = txn.getValue();
            // min
            if (count == 0) {
                min = amount;
            } else if (amount < min) {
                min = amount;
            }
            // max
            if (amount > max) {
                max = amount;
            }
            // sum
            sum += amount;
            // count
            count++;
        }

        Statistics statistics = new Statistics();
        statistics.setAvg(count == 0 ? 0 : sum / count);
        statistics.setCount(count);
        statistics.setMax(max);
        statistics.setSum(sum);
        statistics.setMin(min);

        return statistics;
    }
}
