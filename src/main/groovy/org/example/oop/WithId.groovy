package org.example.oop

trait WithId {
    Integer id

    boolean validateId() {
        return id > 0
    }
}