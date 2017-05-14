package com.hackerrank.thirtydaysofcode;

public class Arithmetic {

    public String totalPrice(double mealPrice, int tipPercent, int taxPercent) {
        double totalTip = mealPrice * (tipPercent / 100d);
        double totalTax = mealPrice * (taxPercent / 100d);
        int totalMeal = (int) Math.round(mealPrice + totalTip + totalTax);

       return "The total meal cost is " + totalMeal + " dollars.";
    }
}
