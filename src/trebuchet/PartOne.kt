package trebuchet

import java.io.File
import java.io.InputStream


fun main(){
    val fileContent = readFromFile("input your file path here")
    println(sumOfCalibrationValues(fileContent))


}

fun readFromFile(filePath: String) : List<String> {

    val inputStream: InputStream = File(filePath).inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { lineList.add(it) }

    return lineList
}

fun sumOfCalibrationValues(input: List<String>): Int{
    var result = 0
    var first = 0
    var last = 0

    input.forEach { line->
        first = line.first{ it.isDigit() }.toString().toInt()
        last = line.last{ it.isDigit() }.toString().toInt()

        result += 10 * first + last
    }

    return result
}