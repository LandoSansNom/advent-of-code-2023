package cubeconundrum

import trebuchet.readFromFile

fun main(){

    val gameList = readFromFile("input your file path here")

    println(sumOfIdOfPossibleGames(gameList,14,12,13))
}


fun sumOfIdOfPossibleGames(gameList: List<String>, blueTarget: Int, redTarget: Int, greenTarget: Int): Int{

    // create three variables blue, red, green
    var blue = 0
    var red = 0
    var green = 0
    var gameWithoutId = ""
    var gameSets = listOf<String>()
    var cubesList = listOf<String>()
    var idGame = 0
    var index = 0
    var result = 0
    var isGamePossible = true

    //  loop game list
   // gameList.forEach { game->
    while (index < gameList.size){
        idGame = index + 1
        // foreach game, get the substring after the space which followed the colon
        gameWithoutId  = gameList[index].substringAfter(": ")
        gameSets = gameWithoutId.split(';')

        //println(gameSets)

        gameSets.forEach { gameSet->

            cubesList = gameSet.split(',')
            cubesList.forEach {cubes->

                if (cubes.contains("red", true)){
                    red = cubes.filter { it.isDigit() }.toString().toInt()
                }
                if (cubes.contains("blue", true)){
                    blue = cubes.filter { it.isDigit() }.toString().toInt()
                }
                if (cubes.contains("green", true)){
                    green = cubes.filter { it.isDigit() }.toString().toInt()
                }

            }

            if (blue > blueTarget || red > redTarget || green > greenTarget){
                isGamePossible = false
            }

            red = 0
            blue = 0
            green = 0

        }

        if (isGamePossible){
            result += idGame
        }

        isGamePossible = true
        index++
    }

    return result
}

