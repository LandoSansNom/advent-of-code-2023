package part_two

import trebuchet.readFromFile


fun main(){
    val fileContent = readFromFile("/Users/consultant/Documents/Tasks/advent-of-code-2023/untitled/src/trebuchet/Trebuchet.txt")

    var sum = 0
    fileContent.forEach { line ->
        // Index, Digit
        val digitsFound = mutableListOf<Pair<Int, Int>>()

        val digits = mapOf(
            "one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5,
            "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9, "zero" to 0,
            "1" to 1, "2" to 2, "3" to 3, "4" to 4, "5" to 5,
            "6" to 6, "7" to 7, "8" to 8, "9" to 9, "0" to 0
        )

        for (digit in digits) {
            if (line.indexOf(digit.key) != -1) {
                digitsFound.add(Pair(line.indexOf(digit.key), digit.value))
                digitsFound.add(Pair(line.lastIndexOf(digit.key), digit.value))
            }
        }

        val sortedDigits = digitsFound.sortedBy { pair -> pair.first }

        sum += 10 * sortedDigits.first().second + sortedDigits.last().second
    }
    println(sum)

}

