package com.hackerrank;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Scanner;

public class Warmup {

    public int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public int[] pontuate(List<Integer> points) {
        int[] pontuation = {0, 0};
        List<Integer> alicePontuation = Lists.partition(points, 3).get(0);
        List<Integer> bobPontuation = Lists.partition(points, 3).get(1);

        for (int i = 0; i < 3; i++) {
           if (alicePontuation.get(i) > bobPontuation.get(i)) {
                pontuation[0]+= 1;
           } else if (alicePontuation.get(i) < bobPontuation.get(i)) {
                pontuation[1]+= 1;
           }
        }

        return pontuation;
    }

    public Long sumBigIntegers(Integer amount, Integer... toBeSum) {
        Long sum = 0L;
        for (int i = 0; i < amount; i++) {
           sum+= toBeSum[i];
        }

        return sum;
    }

    public int getAbsoluteDifference(int amount, int[][] matrix) {
        int firstDiagonal = 0;
        int secondDiagonal = 0;
        int count = 0;

        while (count < amount) {
           firstDiagonal+= matrix[count][count];
           secondDiagonal+= matrix[count][amount - (count + 1)];
           count++;
        }

        return Math.abs(firstDiagonal - secondDiagonal);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int amount = in.nextInt();
        int[][] matrix = new int[amount][amount];

        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < amount; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        int firstDiagonal = 0;
        int secondDiagonal = 0;
        int count = 0;

        while (count < amount) {
           firstDiagonal+= matrix[count][count];
           secondDiagonal+= matrix[count][amount - (count + 1)];
           count++;
        }

        System.out.println(Math.abs(firstDiagonal - secondDiagonal));
    }
}
