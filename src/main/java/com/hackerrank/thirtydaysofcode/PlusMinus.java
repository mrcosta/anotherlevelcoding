package com.hackerrank.thirtydaysofcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlusMinus {

    public String[] classificateNumbers(List<Integer> numbers) {
        List<Integer> amounts= new ArrayList<>(Collections.nCopies(3, 0));

        for (Integer number: numbers) {
            if (number > 0) {
                amounts.set(0, amounts.get(0) + 1);
            } else if (number < 0) {
                amounts.set(1, amounts.get(1) + 1);
            } else {
                amounts.set(2, amounts.get(2) + 1);
            }
        }

        float positivesPercentage = ((float) (amounts.get(0)) / numbers.size());
        float negativePercentage = ((float) (amounts.get(1)) / numbers.size());
        float zeroPercentage = ((float) (amounts.get(2)) / numbers.size());

        return new String[]{String.format("%.6f", positivesPercentage),
                String.format("%.6f", negativePercentage),
                String.format("%.6f", zeroPercentage)};
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int amount = scan.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
          numbers.add(scan.nextInt());
        }

        for (String percentage: new PlusMinus().classificateNumbers(numbers)) {
            System.out.println(percentage);
        }
    }
}
