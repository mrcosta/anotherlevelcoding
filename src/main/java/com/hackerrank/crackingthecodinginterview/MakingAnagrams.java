package com.hackerrank.crackingthecodinginterview;

public class MakingAnagrams {

    public int necessaryDeletionNumber(String firstWord, String secondWord) {
        String biggestWord = firstWord.length() >= secondWord.length() ? firstWord : secondWord;
        String smallestWord = firstWord.length() < secondWord.length() ? firstWord : secondWord;

        StringBuilder biggestWordBuilder = new StringBuilder(biggestWord);
        StringBuilder toBeDeleted = new StringBuilder();

        for (char letter : smallestWord.toCharArray()) {
            if (letterExistInWord(biggestWordBuilder, letter)) {
                biggestWordBuilder.deleteCharAt(biggestWordBuilder.toString().indexOf(letter));
            } else {
                toBeDeleted.append(letter);
            }
        }

        return biggestWordBuilder.length() + toBeDeleted.length();
    }

    private boolean letterExistInWord(StringBuilder biggestWordBuilder, char letter) {
        return biggestWordBuilder.toString().indexOf(letter) >= 0;
    }
}
