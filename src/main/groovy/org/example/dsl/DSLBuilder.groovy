package org.example.dsl

class DSLBuilder {
    static MailSpecification mail(@DelegatesTo(MailSpecification) Closure closure){
        def specification = new MailSpecification()
//        closure.delegate = specification
//        closure.resolveStrategy = Closure.DELEGATE_ONLY
//        closure()
        specification.with closure
        specification
    }
}
