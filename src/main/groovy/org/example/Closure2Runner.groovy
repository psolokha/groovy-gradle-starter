package org.example

import org.example.closures.ClosureTester
import org.example.oop.Student

/**
 * Closure closure = {}     declaration
 * closure()                execution
 */

class Closure2Runner {
    static void main(String[] args) {
        def student = new Student("Quincy", "Promes", 10)

        Closure closure = {
            firstName = "Aruna"
        }

        // delegate
        closure.delegate = student
        closure()

        println student

        // or using with
        def closure2 = { lastName = "Babangida" }
        student.with closure2

        println student

        def tester = new ClosureTester(name: "first Tester", id: 1)
        println tester
        tester.getInfo()()
    }
}
