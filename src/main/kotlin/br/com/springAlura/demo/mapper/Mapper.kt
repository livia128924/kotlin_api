package br.com.springAlura.demo.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}
