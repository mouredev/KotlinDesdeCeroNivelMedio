package com.mouredev.kotlinintermedio

/**
 * Created by MoureDev by Brais Moure on 23/10/2020.
 * www.mouredev.com
 */
class MyNestedAndInnerClass {

    private val one = 1

    private fun returnOne() : Int {
        return one
    }

    // Clase Anidada (Nested Class)
    class MyNestedClass {

        fun sum(first: Int, second: Int) : Int {
            return first + second
        }

    }

    // Clase Interna (Inner Class)
    inner class MyInnerClass {

        fun sumTwo(number: Int) : Int {
            return number + one + returnOne()
        }

    }


}