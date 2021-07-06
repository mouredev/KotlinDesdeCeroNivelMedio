package com.mouredev.kotlinintermedio

/**
 * Created by MoureDev by Brais Moure on 10/11/2020.
 * www.mouredev.com
 */
class Programmer(name: String, age: Int, val language: String): Person(name, age), Vehicle {

    override fun work() {
        println("Esta persona está programando")
    }

    fun sayLanguage() {
        println("Este programador usa el lenguaje $language")
    }

    override fun goToWork() {
        println("Esta persona va a Google")
    }

    override fun drive() {
        println("Esta persona conduce un coche")
    }

}