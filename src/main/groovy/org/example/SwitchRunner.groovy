package org.example

class SwitchRunner {
    static void main(String[] args) {
        int x = 12

        switch (x) {
            case String:            // isInstance x.getClass == String.class
                println 0
                break
            case 5:                 // equals == ===
                println 1
                break
            case ~/\d+/:            // pattern.matcher(x.toString()).matches()
                println 2
                break
            case { it % 5 == 0}:    // closure.
                println 3
                break
            case [1,3,5,9]:
                println 4
                break
            default:
                println "none"
                break
        }

        /**
         * inCase() -> method
         */
        def unit = new Unit(10)
        switch (unit) {
            case new Unit(5): println "this case 5"
                break
            case new Unit(10): println "this case 10"
                break
            case new Unit(15): println "this case 15"
                break
            default: println "default case"
                break
        }

       if (x in [1,2,10, 12,20]) println x
    }

}
