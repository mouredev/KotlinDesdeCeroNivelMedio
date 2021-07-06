package com.mouredev.kotlinintermedio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

typealias MyMapList = MutableMap<Int, ArrayList<String>>
typealias MyFun = (Int, String, MyMapList) -> Boolean
typealias MyNestedClass = MyNestedAndInnerClass.MyNestedClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enum Classes
        //enumClasses()

        // Nested and Inner Classes
        //nestedAndInnerClasses()

        // Class Inheritance
        //classInheritance()

        // Interfaces
        //interfaces()

        // Visibility Modifiers
        //visibilityModifiers()

        // Data classes
        //dataClasses()

        // Type aliases
        //typeAliases()

        // Destructuring declarations
        //destructuringDeclarations()

        // Extensions
        //extensions()

        // Lambdas
        lambdas()
    }

    // Lección 1 Kotlin Intermedio: Enum Classes

    enum class Direction(val dir: Int) {

        NORTH(1), SOUTH(-1), EAST(1), WEST(-1);

        fun description(): String {

            return when (this) {
                NORTH -> "La dirección es NORTE"
                SOUTH -> "La dirección es SUR"
                EAST -> "La dirección es ESTE"
                WEST -> "La dirección es OESTE"
            }
        }
    }

    private fun enumClasses() {

        // Asignación de valores
        var userDirection: Direction? = null
        println("Dirección: $userDirection")

        userDirection = Direction.NORTH
        println("Dirección: $userDirection")

        userDirection = Direction.WEST
        println("Dirección: $userDirection")

        // Propiedades por defecto
        println("Propiedad name: ${userDirection.name}")
        println("Propiedad ordinal: ${userDirection.ordinal}")

        // Funciones
        println(userDirection.description())

        // Inicialización
        println(userDirection.dir)
    }

    // Lección 2 Kotlin Intermedio: Nested and Inner Classes

    private fun nestedAndInnerClasses() {

        // Clase anidada (nested)
        val myNestedClass = MyNestedClass()
        val sum = myNestedClass.sum(10, 5)
        println("El resultado de la suma es $sum")

        // Clase interna (inner)
        val myInnerClass = MyNestedAndInnerClass().MyInnerClass()
        val sumTwo = myInnerClass.sumTwo(10)
        println("El resultado de sumar dos es $sumTwo")
    }

    // Lección 3 Kotlin Intermedio: Class Inheritance

    private fun classInheritance() {

        val person = Person("Sara", 40)

        val programmer = Programmer("Brais", 33, "Kotlin")
        programmer.work()
        programmer.sayLanguage()
        programmer.goToWork()
        programmer.drive()

        val designer = Designer("Juan", 30)
        designer.work()
        designer.goToWork()
    }

    // Lección 4 Kotlin Intermedio: Interfaces

    private fun interfaces() {

        val gamer = Person("Brais", 33)
        gamer.play()
        gamer.stream()
    }

    // Lección 5 Kotlin Intermedio: Visibility Modifiers

    private fun visibilityModifiers() {

        //val visibility = Visibility()
        //visibility.name = "Brais"
        //visibility.sayMyName()

        val visibilityTwo = VisibilityTwo()
        //visibilityTwo.sayMyNameTwo()
    }

    // Lección 6 Kotlin Intermendio: Data Classes

    private fun dataClasses() {

        val brais = Worker("Brais Moure", 33, "Programador")
        brais.lastWork = "Músico"

        val sara = Worker()

        val mouredev = Worker("Brais Moure", 33, "Programador")
        mouredev.lastWork = "Músico"

        // equals & hashCode
        if (brais == mouredev) {
            println("Son iguales")
        } else {
            println("No son iguales")
        }

        // toString
        println(brais.toString())

        // copy
        val brais2 = brais.copy(age = 34)
        println(brais.toString())
        println(brais2.toString())

        // componentN
        val (name, age) = mouredev
        println(name)
        println(age)
    }

    // Lección 7 Kotlin Intermendio: Type aliases

    private var myMap: MyMapList = mutableMapOf()

    private fun typeAliases() {

        val myNewMap: MyMapList = mutableMapOf()
        myNewMap[1] = arrayListOf("Brais", "Moure")
        myNewMap[2] = arrayListOf("MoureDev", "by Brais Moure")

        myMap = myNewMap
    }

    // Lección 8 Kotlin Intermedio: Destructuring declarations

    private fun destructuringDeclarations() {

        val (name, _, work) = Worker("Brais Moure", 34, "Programador")
        println("$name, $work")

        val mouredev = Worker("MoureDev", 34, "Programador")
        println(mouredev.component1())

        val (braisName, braisAge) = myWorker()
        println("$braisName, $braisAge")

        val myMap = mapOf(1 to "Brais", 2 to "Ana", 3 to "Sara")
        for ((id, name) in myMap) {
            println("$id, $name")
        }
    }

    private fun myWorker(): Worker {
        return Worker("Brais Moure", 34, "Programador")
    }

    // Lección 9 Kotlin Intermedio: Extensions

    private fun extensions() {

        val myDate = Date()
        println(myDate.customFormat())
        println(myDate.formatSize)

        var myDateNullable: Date? = null
        println(myDateNullable.customFormat())
        println(myDateNullable.formatSize)
    }

    // Lección 10 Kotlin Intermedio: Lambdas

    private fun lambdas() {

        val myIntList = arrayListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val myFilterIntList = myIntList.filter { myInt ->

            println(myInt)
            if (myInt == 1) {
                return@filter true
            }

            myInt > 5
        }
        println(myFilterIntList)

        val mySumFun = fun (x: Int, y: Int): Int = x + y
        val myMultFun = fun (x: Int, y: Int): Int = x * y

        myAsyncFun("MoureDev") {
            println(it)
        }

        println(myOperateFun(5, 10, mySumFun))
        println(myOperateFun(5, 10, myMultFun))
        println(myOperateFun(5, 10) { x, y -> x - y })
    }

    private fun myOperateFun(x: Int, y: Int, myFun: (Int, Int) -> Int): Int {
        return myFun(x, y)
    }

    private fun myAsyncFun(name: String, hello: (String) -> Unit) {
        val myNewString = "Hello $name!"
        thread {
            Thread.sleep(5000)
            hello(myNewString)
        }

        thread {
            Thread.sleep(1000)
            hello(myNewString)
        }

        thread {
            Thread.sleep(7000)
            hello(myNewString)
        }
    }

}