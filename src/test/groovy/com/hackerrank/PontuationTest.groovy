package com.hackerrank

import spock.lang.Specification

class PontuationTest extends Specification {

    def "should pontuate notes"() {
        def pontuation = new Pontuation()

        when:
        def result = pontuation.pontuate([5, 6, 7, 3, 6, 10])

        then:
        result == [1, 1]
    }
}
