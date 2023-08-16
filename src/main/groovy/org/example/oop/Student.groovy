package org.example.oop

import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@TupleConstructor
class Student {
    String firstName
    String lastName
    int age

    def getAt(Integer index) {
        index == 0 ?
                firstName : (index == 2) ?
                                    age : lastName
    }
}
