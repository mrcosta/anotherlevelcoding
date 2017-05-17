package com.qualified;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakeChange {

    public long countChange(Integer amount, List<Integer> denominations) {
        return isValidInput(amount, denominations) ? getPossibleWaysToGiveChange(amount, denominations, 0, new HashMap<>()) : 0;
    }

    private boolean isValidInput(Integer amount, List<Integer> denominations) {
        return amount > 0 && denominations != null && !denominations.isEmpty();
    }

    private long getPossibleWaysToGiveChange(Integer amount, List<Integer> denominations, Integer denominationIndex, Map<String, Long> alreadyCounted) {
        if (amount == 0) {
            return 1;
        } else if (denominationIndex == denominations.size()) {
            return 0;
        } else {
            return getTotalWays(amount, denominations, denominationIndex, alreadyCounted);
        }
    }

    private long getTotalWays(Integer amount, List<Integer> denominations, Integer denominationIndex, Map<String, Long> alreadyCounted) {
        String key = amount + "-" + denominationIndex;
        if (alreadyCounted.containsKey(key)) {
            return alreadyCounted.get(key);
        } else {
            return calculateForNewAmount(amount, denominations, denominationIndex, alreadyCounted);
        }
    }

    private long calculateForNewAmount(Integer amount, List<Integer> denominations, Integer denominationIndex, Map<String, Long> alreadyCounted) {
        Integer amountWithCoin = 0;
        long totalWays = 0;

        while (amountWithCoin <= amount) {
            Integer amountRemaining = amount - amountWithCoin;
            totalWays+= getPossibleWaysToGiveChange(amountRemaining, denominations, denominationIndex + 1, alreadyCounted);
            amountWithCoin += denominations.get(denominationIndex);
        }

        alreadyCounted.put(amount + " - " + denominationIndex, totalWays);
        return totalWays;
    }
}
