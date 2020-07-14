package search

import java.awt.image.BufferStrategy
import java.io.File
import java.util.*

// MutableMap and MutableList

fun main(args: Array<String>) {



}

class SearchEngine {
    private val scanner = Scanner(System.`in`)
    private val people1 = mutableMapOf<Int, List<String>>()
    private lateinit var people: List<String>

    fun init(args: Array<String>) {
        people = File(args[1]).readLines()
        for (line in 1..File(args[1]).readLines().size) {
            people1[line] = people[line - 1].split(" ")
        }
    }

    fun keep() {
        do {
            val keep = menu()
        } while (keep)
    }

    private fun menu(): Boolean {
        println("=== Menu ===")
        println("1. Find a person")
        println("2. Print all people")
        println("0. Exit")
        when (scanner.next()) {
            "1" -> find(strategySearch())
            "2" -> people.forEach(::println)
            "0" -> { println("Bye!"); return false }
            else -> println("Incorrect option! Try again.")
        }
        return true
    }

    private fun strategySearch(): String {
        println("Select a matching strategy: ALL, ANY, NONE")
        return scanner.nextLine()
    }

    private fun find(strategy: String) {
        println("Enter a name or email to search all suitable people.")
        val search = scanner.next().toLowerCase()
        val founded = mutableListOf<Int>()
        repeat(people1.size) {
            val line = people1[it]
            line?.forEach {
                w ->
                if (w.toLowerCase() == search) {
                    founded.add(founded.size, it)
                }
            }
        }

        if (founded.isNotEmpty()) {
            println("Found people:")
            founded.forEach { println(people[it - 1])}
        } else {
            println("No matching people found.")
        }
    }
}
