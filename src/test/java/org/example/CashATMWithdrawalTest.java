package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class CashATMWithdrawalTest {

    @Test
    public void testCaseValidWithdrawal() {
        CashATMWithdrawal dispenser = new CashATMWithdrawal();
        Map<Integer, Integer> result = dispenser.withdrawATMCash(380);
        assertEquals(4, result.size(), "Expected 4 notes, but got " + result.size());
        assertEquals(3, result.get(100).intValue(), "Expected 3 notes of 100, but got " + result.get(100));
        assertEquals(1, result.get(50).intValue(), "Expected 1 note of 50, but got " + result.get(50));
        assertEquals(1, result.get(20).intValue(), "Expected 1 note of 20, but got " + result.get(20));
        assertEquals(1, result.get(10).intValue(), "Expected 1 note of 10, but got " + result.get(10));
    }

    @Test
    public void testCaseInvalidAmount() {
        CashATMWithdrawal dispenser = new CashATMWithdrawal();
        assertThrows(IllegalArgumentException.class, () -> dispenser.withdrawATMCash(375));
    }

    @Test
    public void testCaseInsufficientFunds() {
        CashATMWithdrawal dispenser = new CashATMWithdrawal();
        assertThrows(IllegalArgumentException.class, () -> dispenser.withdrawATMCash(2000));
    }

    @Test
    public void testCaseZeroAmount() {
        CashATMWithdrawal dispenser = new CashATMWithdrawal();
        assertThrows(IllegalArgumentException.class, () -> dispenser.withdrawATMCash(0));
    }
}
