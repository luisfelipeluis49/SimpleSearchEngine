package search

import java.io.File
import java.util.*

// MutableMap and MutableList

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val people = File(args[1]).readLines()
    val people1 = mutableMapOf<Int, List<String>>()
    for (line in 1..File(args[1]).readLines().size) {
        people1[line] = people[line - 1].split(" ")
    }

    do {
        val keep = menu(scanner, people, people1)
    } while (keep)

}

fun menu(scanner: Scanner, people: List<String>, people1: MutableMap<Int, List<String>>): Boolean {
    println("=== Menu ===")
    println("1. Find a person")
    println("2. Print all people")
    println("0. Exit")
    when (scanner.next()) {
        "1" -> find(scanner, people, people1)
        "2" -> people.forEach(::println)
        "0" -> { println("Bye!"); return false }
        else -> println("Incorrect option! Try again.")
    }
    return true
}

fun find(scanner: Scanner, people: List<String>, people1: MutableMap<Int, List<String>>) {
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
