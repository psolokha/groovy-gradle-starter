package org.example

class Main {

    static void main(String[] args) {
//        println "Hello world!"
//
//        var num = -32455356;
//        var reminder = Math.abs(num) % 10 // Выделяем последнее число (два последних %100, три - %1000)
//        if(reminder == 6) println("6! True")
//        else println("No.")

        int result = factorial(5);
        println result
    }

    static int factorial(int value) {
        if (value == 1) return 1
        return value * factorial(value-1)
    }

}