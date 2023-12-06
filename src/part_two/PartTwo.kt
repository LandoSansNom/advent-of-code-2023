package part_two

import trebuchet.readFromFile
import java.util.Collections


// stringA.contains(stringB, ignoreCase = true)
// split from a specific index
// val substring = string.drop(string.indexOf('t')).take(7)
// const address = '100 Queen St W, Toronto, ON M5H 2N2';
// const civicNumber = address.substr(0, address.indexOf(' '));
// val exist = map.containsValue(value)
//  map.forEach { (key, value) -> println("$key = $value") }
// println(string.last { it.isLetter() }) // n


fun main(){
    val fileContent = readFromFile("/Users/consultant/Documents/Tasks/advent-of-code-2023/untitled/src/trebuchet/Trebuchet.txt")
    val digitsMap = hashMapOf<String, Int>("One" to 1, "Two" to 2, "Three" to 3, "Four" to 4, "Five" to 5, "Six" to 6, "Seven" to 7, "Eight" to 8, "Nine" to 9)
    var result = 0
    var first = ""
    var last = ""
    var substringBeforeDigit = ""
    var substringAfterDigit = ""
    var letterDigits = hashMapOf<String, Int>()
    var indexes = emptyList<Int>()
    var sumofIndex = 0

    fileContent.forEach { line ->

        try {
            first = ""
            first = line.first { it.isDigit() }.toString()

        }catch (e: Exception){
            e.printStackTrace()
        }


        if (first != ""){
            substringBeforeDigit = line.substringBefore(first)
        }else{
            substringBeforeDigit = line
        }


        if (substringBeforeDigit != "") {
            digitsMap.forEach { key, value ->
                if (substringBeforeDigit.contains(key, true)) {
                    letterDigits.put(key,0)
                    println("substringBeforeDigit: $substringBeforeDigit letterDigits: $letterDigits")
                }


                letterDigits.forEach { key, value ->

                    indexes = substringBeforeDigit.indexesOf(key)

                    for (i in indexes.indices){
                        sumofIndex += indexes[i]
                    }

                //    letterDigits[key] = sumofIndex

                }


            }
        }


        try {
            last = line.last { it.isDigit() }.toString()
        }catch (e: Exception){
         e.printStackTrace()
        }

        if (last != ""){
            substringAfterDigit = line.substringAfter(last)
        }else{
            substringAfterDigit = line
        }


        if (substringAfterDigit != "") {
            digitsMap.forEach { key, value ->

                if (substringAfterDigit.contains(key, true)) {
                    //  println("substring: $substringAfterDigit, digit in letter format: $key")
                    last = value.toString()
                }
            }
        }
        result += "$first$last".toInt()
    }
}



public fun String?.indexesOf(substr: String, ignoreCase: Boolean = true): List<Int> {
    return this?.let {
        val regex = if (ignoreCase) Regex(substr, RegexOption.IGNORE_CASE) else Regex(substr)
        regex.findAll(this).map { it.range.start }.toList()
    } ?: emptyList()
}
