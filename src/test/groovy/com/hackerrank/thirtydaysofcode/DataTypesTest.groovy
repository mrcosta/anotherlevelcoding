package com.hackerrank.thirtydaysofcode

import spock.lang.Specification

class DataTypesTest extends Specification {

    def "should return int plus static int variable"() {
        def dataTypes = new DataTypes()

        when:
        def result = dataTypes.sumInt(12)

        then:
        result == 16
    }

    def "should return double plus static double variable with one decimal place"() {
        def dataTypes = new DataTypes()

        when:
        def result = dataTypes.sumDouble(12.00)

        then:
        result == 16.0
    }

    def "should concatenate static string with the input"() {
        def dataTypes = new DataTypes()

        when:
        def result = dataTypes.concatenateStrings("hi from")

        then:
        result == "HaxkerRank hi from"
    }
}
