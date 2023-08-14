package org.example

class LoopsRunner {
    static void main(String[] args) {
        //while / for

        /**
         * for (int i = 0; i <= 10; i++) {
         * println i
         * }
         */

        // #1
        for (i in 0..10) {
            println "fori-" + i
        }

        // #2
        0.upto(10){println "upto-$it"}
        10.downto(0) { println "downto-$it"}

        // #3
        10.times { println "times-$it"}

        // #4
        0.step(10, 1) { println "step-$it"}
        0.step(10, 3) { println "step3-$it"}



    }


}
