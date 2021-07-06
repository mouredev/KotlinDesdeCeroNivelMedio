package com.mouredev.kotlinintermedio

/**
 * Created by MoureDev by Brais Moure on 10/11/2020.
 * www.mouredev.com
 */
interface Game {

    val game: String

    fun play()

    fun stream() {
        println("Estoy haciendo stream de mi juego $game")
    }

}