package com.hackerrank.crackingthecodinginterview

import spock.lang.Specification

class ArrayLeftRotationTest extends Specification {

    def "should return modified array according to number of rotations"() {
       def arrayLeftRotation = new ArrayLeftRotation()

        when:
        def modifiedArray = arrayLeftRotation.modifyArray(4, [1, 2, 3, 4, 5])

        then:
        modifiedArray == "5 1 2 3 4"
    }
}
