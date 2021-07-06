package com.mouredev.kotlinintermedio

/**
 * Created by MoureDev by Brais Moure on 10/11/2020.
 * www.mouredev.com
 */
private class Visibility {

    var name: String? = null

    private fun sayMyName() {
        name?.let {
            println("Mi nombre es $it")
        } ?: run {
            println("No tengo nombre")
        }
    }

}

open class VisibilityTwo {

    protected fun sayMyNameTwo() {

        val visibility = Visibility()
        visibility.name = "Brais"
    }

}

class VisibilityThree: VisibilityTwo() {

    internal val age: Int? = null

    fun sayMyNameThree() {
        sayMyNameTwo()
    }

}

