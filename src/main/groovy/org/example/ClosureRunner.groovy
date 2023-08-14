package org.example

import java.util.function.Function
import java.util.stream.Stream

class ClosureRunner {
    static void main(String[] args) {

        Stream.of(1, 2, 3, 4)
                .map(value -> value + value) // -> Function<Integer, Integer> func = value -> value+value;
                .map(String::valueOf)
                .forEach(System.out::println)

        Function<Integer, Integer> func = value -> value + value
        int result = func.apply(5)
        System.out.println(result)

        // Typing same closures
        // #1 the same as Function<Integer, Integer> closure = value -> value + value
//        Closure closure = value -> value + value

        // #2 with println
        /*
        def closure = { value ->
            println value
            value + value // -> return
        }
         */
        // #3 with 'it'
        def closure = {
            println it
            it + it
        }
//        def closureResult = closure.call(6)
        def closureResult = closure(6) //the same
        println closureResult


        int x = 17

//        check(x > 0, { println (++x) })
        check(x > 0) {
            println (++x)
        }
    }

    static def check(boolean condition, Closure closure) {
        if (condition) {
            closure()
        }
    }
}
