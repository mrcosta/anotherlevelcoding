package com.hackerrank.crackingthecodinginterview

import spock.lang.Specification

class MakingAnagramsTest extends Specification {

    def "should get necessary number of deletions to make two word an anagram"() {
        def makingAnagrams = new MakingAnagrams()

        when:
        def result = makingAnagrams.necessaryDeletionNumber("cde", "abc")

        then:
        result == 4
    }

    def "should get necessary number of deletions to make two word an anagram when there are repeated letters"() {
        def makingAnagrams = new MakingAnagrams()

        when:
        def result = makingAnagrams.necessaryDeletionNumber("adde", "aaf")

        then:
        result == 5
    }

    def "should get necessary number of deletions to make two word an anagram - hackerrank example"() {
        def makingAnagrams = new MakingAnagrams()

        when:
        def result = makingAnagrams.necessaryDeletionNumber("tttttttttttttttttttttttttttttttttttttsssssssssssssssss", "sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss")

        then:
        result == 107
    }
}
