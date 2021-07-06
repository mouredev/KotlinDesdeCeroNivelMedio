package com.mouredev.kotlinintermedio

/**
 * Created by MoureDev by Brais Moure on 10/11/2020.
 * www.mouredev.com
 */
class Designer(name: String, age: Int): Person(name, age) {

    override fun work() {
        println("Esta persona está diseñando")
        super.work()
    }

}