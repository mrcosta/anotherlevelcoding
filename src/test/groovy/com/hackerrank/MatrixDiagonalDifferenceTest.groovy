package com.hackerrank

import spock.lang.Specification

class MatrixDiagonalDifferenceTest extends Specification {

    def "should sum integers"() {
        def warmup = new MatrixDiagonalDifference()

        when:
        def sum = warmup.sum([15, 16])

        then:
        sum == 31
    }

    def "should get the absolute difference between the diagonals of a matrix"() {
        def warmup = new MatrixDiagonalDifference()

        when:
        int[][] matrix = [[11, 2, 4], [4, 5, 6], [10, 8, -12]]
        def absoluteDifference = warmup.getAbsoluteDifference(3, matrix)

        then:
        absoluteDifference == 15
    }
}
