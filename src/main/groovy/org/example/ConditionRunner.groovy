package org.example
/**
 * if (<type>):
 * boolean          is true
 * Collection/Map   is not empty
 * Matcher          has match
 * String/GString   is not empty
 * Number/Char      != 0
 * reference        != null
 */
class ConditionRunner {
    static void main(String[] args) {
        int x = 10
        /**
         def condition = x > 0
         if (condition) println x
         */
        if (x) println x

        /**
         * asBoolean -> method
         */
        def unit = new Unit(14)
        if (unit) println unit

        /**
         * if (unit != null) unit.toString()
         */
        unit?.toString()

        /**
         * def result = x != null ? x : 1
         * def result = x ? x : 1
         * def result = x ?: 1
         */
        println x ?: 1
    }

}


