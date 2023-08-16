package org.example.oop

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor
import groovy.transform.builder.Builder

@ToString
@TupleConstructor
@EqualsAndHashCode
@Builder
class StudentWithId implements WithId{
    String firstName
    String lastName
    int age

    def getAt(Integer index) {
        index == 0 ?
                firstName : (index == 2) ?
                age : lastName
    }
}
