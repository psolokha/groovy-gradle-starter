package org.example

class ListRunner {
    static void main(String[] args) {
        def list = [1,2,3,4,5,6,7]

        // read:
        assert list[2] == 3
        assert list.get(2) == 3
        assert list[-1] == 7
        assert list[-2] == 6
        assert list[1..3] == [2,3,4]
        assert list[10] == null

        // write:
        list += 9
        list << 10
        list << 11 << 12 << 13
        assert list == [1,2,3,4,5,6,7, 9, 10, 11, 12, 13]
        list << 7 << 7 << 7 << 7
        list -= 7 // deletes all 7's
        assert list == [1,2,3,4,5,6, 9, 10, 11, 12, 13]
        list << 1 << 1 << 1 << 1
        list << 3 << 3 << 3 << 3
        println list
        list -= [1,3]
        assert list == [2,4,5,6, 9, 10, 11, 12, 13]
        list *= 3
        assert list == [2,4,5,6, 9, 10, 11, 12, 13, 2,4,5,6, 9, 10, 11, 12, 13, 2,4,5,6, 9, 10, 11, 12, 13]

        // method from queue
        list.push(999)
        println list
        assert list.pop() == 999 // deletes first and return
        assert list.head() == 2
        // list.tail() == list - list.head()
        assert list.tail() == [4,5,6, 9, 10, 11, 12, 13, 2,4,5,6, 9, 10, 11, 12, 13, 2,4,5,6, 9, 10, 11, 12, 13]
        assert list.last() == 13

        // flatten, reverse, intersect, disjoint
        assert [1,2, [4,6,7], 9].flatten() == [1,2,4,6,7,9]
        assert [1,2, [4,6,7], 9].flatten().reverse() == [9,7,6,4,2,1]
        assert [2,3,4,5].intersect([3,5,7,9]) == [3,5]
        assert [1,2,3].disjoint([5,6,7])

        // new operators
        def (a,b,c) = [3,5,7,9,10]
        assert a == 3
        assert b == 5
        assert c == 7

        func(*[8,10]) // *[a,b] -> int a, int b
    }

    static def func(def a, def b) {
        println a
        println b
    }
}
