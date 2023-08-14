package org.example

class MapRunner {
    static void main(String[] args) {
        // def map = [:]
        def map = [one:1, two:2, three:3] // def map = ["one":1, "two":2, "three":3]
        assert map.getClass() == LinkedHashMap

        // read
        assert map.get("one") == 1
        assert map["one"] == 1
        assert map."one" == 1
        assert map.one == 1
        assert map.get("five", 5) == 5

        // write
        map.one = 111

        // new method
        assert map.subMap("one", "two") == ["one":111, "two":2]

        // new operator
        def newMap = ["q": 22, "rt": 99, *:map]
        println newMap
    }
}
