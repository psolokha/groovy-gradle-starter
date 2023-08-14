package org.example

class RangeRunner {
    static void main(String[] args) {
        def range = 2..8 // IntRange
        assert range.getClass() == IntRange

        assert range.get(3) == 5
        assert range.contains(8)
        def range1 = 2..<8
        assert !range1.contains(8)

        ('a'..'d').each { println it}
        (WeekDay.MONDAY..WeekDay.SUNDAY).each { println it}

        (1..10).every {it > 0}
    }
}

enum WeekDay {
    MONDAY,TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
