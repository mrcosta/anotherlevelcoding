package com.hackerrank.crackingthecodinginterview;

public class MakingAnagrams {

    public int necessaryDeletionNumber(String firstWord, String secondWord) {
        StringBuilder biggestWordBuilder = new StringBuilder(firstWord.length() >= secondWord.length() ? firstWord : secondWord);
        StringBuilder smallestWordBuilder = new StringBuilder(firstWord.length() < secondWord.length() ? firstWord : secondWord);

        for (char letter : smallestWordBuilder.toString().toCharArray()) {
            if (letterExistInWord(biggestWordBuilder, letter)) {
                biggestWordBuilder.deleteCharAt(biggestWordBuilder.toString().indexOf(letter));
                smallestWordBuilder.deleteCharAt(smallestWordBuilder.toString().indexOf(letter));
            }
        }

        return biggestWordBuilder.length() + smallestWordBuilder.length();
    }

    private boolean letterExistInWord(StringBuilder biggestWordBuilder, char letter) {
        return biggestWordBuilder.toString().indexOf(letter) >= 0;
    }
}
