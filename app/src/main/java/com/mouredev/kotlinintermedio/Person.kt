package com.mouredev.kotlinintermedio

/**
 * Created by MoureDev by Brais Moure on 10/11/2020.
 * www.mouredev.com
 */
open class Person(name: String, age: Int) : Work(), Game {

    // Cualquier clase tiene una superclase común "Any"

    open fun work() {
        println("Esta persona está trabajando")
    }

    override fun goToWork() {
        println("Esta persona va al trabajo")
    }

    // Game Interface

    override val game: String = "Among Us"

    override fun play() {
        println("Esta persona está jugando a $game")
    }

}