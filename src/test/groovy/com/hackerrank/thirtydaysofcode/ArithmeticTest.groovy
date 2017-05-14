package com.hackerrank.thirtydaysofcode

import spock.lang.Specification


class ArithmeticTest extends Specification {

    def "should calculate meal total price"() {
        def arithmetic = new Arithmetic()

        when:
        def totalPrice = arithmetic.totalPrice(12.00, 20, 8)

        then:
        totalPrice == "The total meal cost is 15 dollars."
    }
}
