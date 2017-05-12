package com.hackerrank

import spock.lang.Specification

class WarmupTest extends Specification {

    def "should sum integers"() {
        def warmup = new Warmup()

        when:
        def sum = warmup.sum([15, 16])

        then:
        sum == 31
    }

    def "should pontuate notes"() {
        def warmup = new Warmup()

        when:
        def pontuation = warmup.pontuate([5, 6, 7, 3, 6, 10])

        then:
        pontuation == [1, 0]
    }

    def "should sum big integers"() {
        def warmup = new Warmup()

        when:
        def sum = warmup.sumBigIntegers(5, 1000000001, 1000000002, 1000000003, 1000000004, 1000000005)

        then:
        sum == 5000000015
    }

    def "should get the absolute difference between the diagonals of a matrix"() {
        def warmup = new Warmup()

        when:
        int[][] matrix = [[11, 2, 4], [4, 5, 6], [10, 8, -12]]
        def absoluteDifference = warmup.getAbsoluteDifference(3, matrix)

        then:
        absoluteDifference == 15
    }
}
