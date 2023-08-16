package org.example.mop

import java.lang.reflect.Field
import java.lang.reflect.Method

class CustomMetaClass {

    /**
     * methods and fields in groovy at Map
     *      name    method
     * Map <String, Method> methods = new HashMap<>()
     *      name    field
     * Map <String, Field> fields = new HashMap<>()
     */

    Map<String, Method> test1methods = new HashMap<>()
    Map<String, Field> test1fields = new HashMap<>()

    def methodMissing(String name, Object args) {
        println "there is no method $name and args $args"
    }

    def propertyMissing(String name) {
        println "there is no field $name"
        "returned data of missing field here"
    }

}
