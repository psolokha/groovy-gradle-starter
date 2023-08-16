package org.example.closures

import groovy.transform.ToString

@ToString
class ClosureTester {
    String name
    int id

    static def getInfo() {
        Closure closure = {
            println thisObject
            println owner
            println delegate
            Closure second = {
                println thisObject
                println owner
                println delegate
            }
            second()
        }
        closure
    }
}