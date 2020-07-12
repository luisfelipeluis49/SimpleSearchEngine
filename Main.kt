package search

import java.io.File
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val people = File(args[1]).readLines()

    do {
        val keep = menu(scanner, people)
    } while (keep)

}

fun menu(scanner: Scanner, people: List<String>): Boolean {
    println("=== Menu ===")
    println("1. Find a person")
    println("2. Print all people")
    println("0. Exit")
    when (scanner.next()) {
        "1" -> find(scanner, people)
        "2" -> people.forEach(::println)
        "0" -> { println("Bye!"); return false }
        else -> println("Incorrect option! Try again.")
    }
    return true
}

fun find(scanner: Scanner, people: List<String>) {
    println("Enter a name or email to search all suitable people.")
    val search = scanner.next().toLowerCase()
    val founded = people.filter { it.contains(search, ignoreCase = true) }

    if (founded.isNotEmpty()) {
        println("Found people:")
        founded.forEach(::println)
    } else {
        println("No matching people found.")
    }
}
