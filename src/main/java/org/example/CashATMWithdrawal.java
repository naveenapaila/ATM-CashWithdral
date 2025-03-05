package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CashATMWithdrawal {
    private Map<Integer, Integer> denominationCount;

    public CashATMWithdrawal() {
        denominationCount = new TreeMap<>(Collections.reverseOrder());
        denominationCount.put(100, 10);
        denominationCount.put(50, 10);
        denominationCount.put(20, 10);
        denominationCount.put(10, 10);
    }

    public synchronized Map<Integer, Integer> withdrawATMCash(int amount) throws IllegalArgumentException {
        if (amount <= 0 || amount % 10 != 0) {
            throw new IllegalArgumentException("Invalid amount. Amount should be a positive multiple of 10.");
        }

        Map<Integer, Integer> dispensed = new HashMap<>();
        for (int denom : denominationCount.keySet()) {
            int count = Math.min(amount / denom, denominationCount.get(denom));
            if (count > 0) {
                amount -= count * denom;
                denominationCount.put(denom, denominationCount.get(denom) - count);
                dispensed.put(denom, count);
            }
        }

        if (amount > 0) {
            throw new IllegalArgumentException("Insufficient funds in ATM or denomination mismatch.");
        }

        return dispensed;
    }
}
