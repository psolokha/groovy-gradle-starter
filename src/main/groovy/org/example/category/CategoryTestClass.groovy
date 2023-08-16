package org.example.category

@Category(TestUnit.class)
class CategoryTestClass {
    def testMethod() {
        println "testmethod gets id: $id and name: $name"
    }
}
