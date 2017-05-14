package com.hackerrank

import spock.lang.Specification

class SumBigIntegersTest extends Specification {

    def "should sum big integers"() {
        def sumBigIntegers = new SumBigIntegers()

        when:
        def sum = sumBigIntegers.sumBigIntegers(5, 1000000001, 1000000002, 1000000003, 1000000004, 1000000005)

        then:
        sum == 5000000015
    }
}
