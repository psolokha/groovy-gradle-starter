package org.example.oop

class OOPRunner {
    static void main(String[] args) {
        def student = new Student()

        // auto Getters & Setters
        student.firstName = "pasha" // setFirstName method
        println student.firstName // getFirstName method
        println student['firstName'] // getFirstName method
        println student.'firstName' //getFirstName method

        // field access
        println student.@firstName // field firstName

        // конструктор по умолчанию сразу переопределен всеми полями
        // при компиляции используются сеттеры
        def student1 = new Student(firstName: 'misha', lastName: 'ignatov', age: 22)

        // @ToString annotation in Student class
        println student1

        // принудительное создание объекта (указывается тип объекта)
        Student student2 = ['victor', 'mozes', 34]
        println student2

        // getAt() method in Student class
        def (f, l) = student2
        println f
        println l

        def (f1, l1, a1) = student1
        println f1
        println l1
        println a1

        /**
         return collection of fields
         in java List<Student> .stream().map(Student::getFirstName).collect(Collectors.toList())
         List<Student> studList = new ArrayList<>();
         studList.add(student1)
         studList.add(student2)
         List<String> list = studList.stream().map(Student::getFirstName).collect(Collectors.toList())
         println list
         */
        [student1, student2].collect { it.firstName }
        [student1, student2]*.firstName //the same
        [student1, student2].firstName // the same

    }
}
