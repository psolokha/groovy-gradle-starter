package org.example.examples

import org.example.oop.Student

/**
 * Добавить метод инициализации "make" для создания объектов любых классов
 */

class Example1 {
    static void main(String[] args) {
//        new HashSet<>([1,2,3,4]) == HashSet.make([1,2,3,4])

        //Решение
        Class.metaClass.make = { Object[] values ->

            println owner
            println thisObject
            println delegate // import!

            delegate.metaClass.invokeConstructor(values)
        }

        def hashSet = HashSet.make([1, 2, 3, 4])
        def student = Student.make("Ivan","Ivanov", 20)
        def student2 = Student.make("Petr", "Petrov", 22)
        def student3 = Student.make()


        println hashSet
        println student
        println student2
        println student3

    }
}
