package org.example

import org.example.oop.StudentWithId

/**
 * AST annotations:
 * @ToString            adds .toString() method
 * @TupleConstructor    adds constructor with all fields
 * @EqualsAndHashCode   adds .eqauls() and .hashCode()
 * @Canonical           adds all previous annotations
 *
 * @Immutable           makes all fields final
 * @Builder             adds builder
 * @Slf4j               adds logger
 *
 * @Mixin               adds mixin (deprecated)
 *
 * others in groovy.transform package
 */
class ASTRunner {
    static void main(String[] args) {
        //using builder
        def student = StudentWithId.builder()
                                        .firstName("daniil")
                                        .lastName("prutsev")
                                        .age(20)
                                        .build()
        println student
    }
}
