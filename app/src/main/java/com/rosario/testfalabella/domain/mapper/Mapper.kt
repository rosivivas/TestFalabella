package com.rosario.testfalabella.domain.mapper

abstract class Mapper<in T, E> {
    abstract fun mapFrom(from: T): E

}