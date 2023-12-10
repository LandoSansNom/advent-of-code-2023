package cubeconundrum

import trebuchet.readFromFile

fun main(){
    val gameList = readFromFile("put your file path here")
    print(sumOfPowerOfSetsOfCubes(gameList))
}


fun sumOfPowerOfSetsOfCubes(gameList: List<String>): Int{

    // create three variables blue, red, green
    var blue = mutableListOf<Int>()
    var red = mutableListOf<Int>()
    var green = mutableListOf<Int>()
    var gameWithoutId = ""
    var gameSets = listOf<String>()
    var cubesList = listOf<String>()
    var result = 0

    //  loop game list
    gameList.forEach { game->
        // foreach game, get the substring after the space which followed the colon
        gameWithoutId  = game.substringAfter(": ")
        gameSets = gameWithoutId.split(';')

        //println(gameSets)

        gameSets.forEach { gameSet->

            cubesList = gameSet.split(',')
            cubesList.forEach {cubes->

                if (cubes.contains("red", true)){
                    red.add(cubes.filter { it.isDigit() }.toString().toInt())
                }
                if (cubes.contains("blue", true)){
                    blue.add(cubes.filter { it.isDigit() }.toString().toInt())
                }
                if (cubes.contains("green", true)){
                    green.add(cubes.filter { it.isDigit() }.toString().toInt())
                }

            }

        }

        println("Max red: ${red.max()} Max blue: ${blue.max()} Max green: ${green.max()}")
        result += red.max() * blue.max() * green.max()

        red.clear()
        blue.clear()
        green.clear()

    }

    return result
}