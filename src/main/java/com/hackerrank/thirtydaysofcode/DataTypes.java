package com.hackerrank.thirtydaysofcode;

import java.util.Scanner;

public class DataTypes {

    public int sumInt(int input) {
        return input + 4;
    }

    public double sumDouble(double doubleInput) {
        return doubleInput + 4;
    }

    public String concatenateStrings(String stringInput) {
        return "HackerRank " + stringInput;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int intInput = scan.nextInt();
        Double doubleInput = scan.nextDouble();
        String stringInput = scan.next() + scan.nextLine();
        DataTypes dataTypes = new DataTypes();

        System.out.println(dataTypes.sumInt(intInput));
        System.out.println(dataTypes.sumDouble(doubleInput));
        System.out.println(dataTypes.concatenateStrings(stringInput));
    }
}