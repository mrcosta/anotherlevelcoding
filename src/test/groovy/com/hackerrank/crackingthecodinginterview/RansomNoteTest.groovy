package com.hackerrank.crackingthecodinginterview

import spock.lang.Specification

class RansomNoteTest extends Specification {

    def "should check all the words to write the note is present in the magazine"() {
        def ransomNote = new RansomNote()
        def magazineWords = ["give", "me", "one", "grand", "today", "night"]
        def noteWords = ["give", "one", "grand", "today"]

        when:
        def result = ransomNote.isPossibleToWriteNote(magazineWords, noteWords)

        then:
        result == "Yes"
    }

}
