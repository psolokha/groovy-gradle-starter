package org.example.oop

class TraitRunner {
    static void main(String[] args) {
        // Не принимо для упрощенного или принудительного создания. Только через явное указание полей класса и трейта
        def student = new StudentWithId(firstName: 'georgy',lastName: 'djikia',age: 32,id: 4)
        println student

        // Simple Groovy Reflection API
        student.properties.each { println it}

        //.mixin() - adds new fictional to class
        String.mixin(TraitRunner.class)

        "vasya".printStr()

    }

    static def printStr(String self) {
        println "I'm student " + self
    }
}
