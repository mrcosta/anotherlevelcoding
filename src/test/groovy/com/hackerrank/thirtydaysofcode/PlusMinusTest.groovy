package com.hackerrank.thirtydaysofcode

import spock.lang.Specification

class PlusMinusTest extends Specification {

    def "should classificate list numbers"() {
        def plusMinus = new PlusMinus()

        when:
        def listOfPercentage = plusMinus.classificateNumbers([-4, 3, -9, 0, 4, 1])

        then:
        listOfPercentage == ["0.500000", "0.333333", "0.166667"]
    }
}
