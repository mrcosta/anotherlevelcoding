package com.hackerrank.crackingthecodinginterview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RansomNote {

    public String isPossibleToWriteNote(List<String> magazineWords, List<String> noteWords) {
        Map<String, Integer> wordsCount = countMagazineWords(magazineWords);

        for (String wordInNote : noteWords) {
            if (!wordsCount.containsKey(wordInNote) || wordsCount.get(wordInNote) == 0) {
                return "No";
            } else {
                wordsCount.put(wordInNote, wordsCount.get(wordInNote) - 1);
            }
        }

        return "Yes";
    }

    private Map<String, Integer> countMagazineWords(List<String> magazineWords) {
        Map<String, Integer> wordsCount = new HashMap<>();
        magazineWords.stream().forEach( word -> wordsCount.merge(word, 1, Integer::sum));

        return wordsCount;
    }
}
