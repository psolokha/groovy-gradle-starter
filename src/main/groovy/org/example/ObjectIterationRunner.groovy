package org.example

class ObjectIterationRunner {
    /**
     *Return value      Method
     * boolean          any {closure}
     * Collection       collect {closure}
     * Object           each {closure}
     * Object           eachWithIndex {closure}
     * boolean          every {closure}
     * Object           find {closure}
     * Collection       findAll {closure}
     * int              findIndexOf {closure}
     * List             findIndexValues {closure}
     * int              findLastIndexOf {closure}
     * Object           inject {closure}
     * Collection       split {closure}
     * List             grep(Object filter)
     */
    static void main(String[] args) {
        assert [1,4,7,9].any {it % 2 == 0}
        assert [1,4,7,9].find {it % 2 == 0} == 4
        assert [1,4,7,9].findAll {it % 2 != 0} == [1,7,9]
        assert (2..4).collect() == [2,3,4]

        def unit = new Unit(45)
        unit.each { println it}

        // isCase -> switch, in, grep
        def grep = ["dfsfdgs", "sefsghwe", "r4t3e4gs", "bvcnmrtes", "889", "9332"].grep(~/\d+/)
        println grep

        def grep1 = ["dfsfdgs", "sefsghwe", "r4t3e4gs", "bvcnmrtes", "889", "9332"].grep {it.length() > 7}
        println grep1
    }
}
