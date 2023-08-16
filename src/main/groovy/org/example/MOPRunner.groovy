package org.example

import org.codehaus.groovy.runtime.DefaultGroovyMethods
import org.example.mop.CustomMetaClass
import org.example.oop.StudentWithId

class MOPRunner {
    static void main(String[] args) {
        def student = StudentWithId.builder()
        .firstName("daniil")
        .lastName("khlusevitch")
        .age(21)
        .build()

        println student.metaClass
//        student.metaClass.abc = "Test abc" // new Field
        student.metaClass.testMethod = { // new Method
            println "it's a new method"
        }

        student.testMethod()
        println student.metaClass

        //new method from other class
        def method = DefaultGroovyMethods.class.getMethod("println", Object.class, Object.class)
        student.invokeMethod("setFirstName", "daaaniiiill")
        println student

        def cms = new CustomMetaClass()
        cms.test1methods.put("println", method)
        def methodFromCMS = cms.test1methods.get("println")
        methodFromCMS.invoke(student, student, student.firstName)
        methodFromCMS.invoke(student, student, "tratata from student object")

        student.class.metaClass.newMethod = {int value ->
            println "this is new method from StudentWithId class with int value $value"
        }

        //student.newMethod(10) -- Exception without creating new object after adding new method to class
        new StudentWithId().newMethod(10)

        cms.missingMethodExecuted("argsForThisMissingMethod")
        println cms.missingFieldHere
    }
}
