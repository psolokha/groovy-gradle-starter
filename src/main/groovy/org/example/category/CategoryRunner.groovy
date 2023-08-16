package org.example.category

class CategoryRunner {
    static void main(String[] args) {
        def unit = new TestUnit(id: 20, name: "opaopa")

        use(CategoryTestClass.class) {
            unit.testMethod()
        }
    }
}
