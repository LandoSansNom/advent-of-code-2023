package trebuchet

import java.io.File
import java.io.FileReader
import java.io.InputStream


fun main(){
    val fileContent = readFromFile("/Users/consultant/IdeaProjects/CodingChallenges/untitled/src/main/kotlin/Trebuchet.txt")
    var result = 0
    var first = ""
    var last = ""

    fileContent.forEach { line->
        first = line.first{ it.isDigit() }.toString()
        last = line.last{ it.isDigit() }.toString()

        result += "$first$last".toInt()
    }

    println(result)

}

fun readFromFile(filePath: String) : List<String> {

    val inputStream: InputStream = File(filePath).inputStream()
    val lineList = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { lineList.add(it) }

    return lineList
}