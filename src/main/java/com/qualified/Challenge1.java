package com.qualified;

import java.util.ArrayList;
import java.util.List;

public class Challenge1 {

    public Integer countChange(Integer money, List<Integer> denominations) {
        return isValidInput(money, denominations) ? getPossibleAmountToGiveChange(money, denominations) : 0;
    }

    private boolean isValidInput(Integer money, List<Integer> denominations) {
        return money > 0 && denominations != null && !denominations.isEmpty();
    }

    private Integer getPossibleAmountToGiveChange(Integer money, List<Integer> denominations) {
        List<String> combinations = new ArrayList<>();

        List toBeSum = new ArrayList();
        toBeSum.add(denominations.get(0));
        getCombinations(money, denominations, toBeSum, 0, new ArrayList<>());

        printCombinations(combinations);

        return combinations.size();
    }

    private List<String> getCombinations(Integer money, List<Integer> denominations, List<Integer> toBeSum, Integer count, List<String> combinations) {
        Integer sum = toBeSum.stream().mapToInt(Integer::intValue).sum();

        if (count == denominations.size()) {
           return combinations;
        } else if (sum == money && !combinations.contains(buildStringCombination(toBeSum))) {
            combinations.add(buildStringCombination(toBeSum));
            toBeSum.remove(toBeSum.size() - 1);
            toBeSum.add(denominations.get(count + 1));
            getCombinations(money, denominations, toBeSum, count + 1, combinations);
        } else if (sum < money) {
            toBeSum.add(denominations.get(count));
            getCombinations(money, denominations, toBeSum, count, combinations);
        }

        toBeSum.remove(toBeSum.size() - 1);
        return getCombinations(money, denominations, toBeSum, count + 1, combinations);
    }

    private String buildStringCombination(List<Integer> toBeSum) {
       String combination = "";

       for (Integer value : toBeSum) {
          combination = combination + " + " + value;
       }

       return combination;
    }

    private void printCombinations(List<String> combinations) {
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}
