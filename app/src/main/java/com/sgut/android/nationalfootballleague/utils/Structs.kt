package com.sgut.android.nationalfootballleague.utils


fun tryThis() {

    val sameSizeArray = Array(3) { Array(3) { '*' } }
//                sameSizeArray.map { println(it.contentToString() )}

//                for (  i in 0.. sameSizeArray.size-1){
//                    sameSizeArray[sameSizeArray.size-1][i] = 'S'
//
//                }
//                sameSizeArray.map { println(it.contentToString() )}
//                println(evens.contentToString())


    val diffSizeArray = Array(2) { Array(0) { "o" } }
//                diffSizeArray.map { println(it.contentToString()) }
// access the [x]th row and assign new array
    diffSizeArray[1] = Array(3) { "-" }
    diffSizeArray[0] = Array(5) { "*" }

//                diffSizeArray.map { println(it.contentToString()) }

    val arrayOne = intArrayOf(1, 2, 3, 4)
    val arrayTwo = intArrayOf(5, 6, 7, 8, 9)
    val arrayThree = intArrayOf(10, 11, 12, 13, 666)
    val multiDimenArray = arrayOf(arrayOne, arrayTwo, arrayThree)
//                multiDimenArray.map { println(it.contentToString()) }

    println("MultiDime size ${multiDimenArray.size}")
    println("MultiDime size  tru index ${multiDimenArray.size - 1}")



    println("MultiDime 1st[0] size ${multiDimenArray[0].size}") // table row 1 size
    println("MultiDime 1st[1] size ${multiDimenArray[1].size}") // table row 2 size
    println("MultiDime 1st[2] size ${multiDimenArray[2].size}") // table row 3 size

    for (ro in multiDimenArray) { // for each row in table
        println("for ro  no edits in marray ${ro.contentToString()}") // print elements in row
    }


    for (ro in 0..multiDimenArray.size - 1) { // for each row in table
        for (col in 0..multiDimenArray[0].size - 1) { // for each column in table[row]
            multiDimenArray[1] =
                intArrayOf(1, 1, 1, 1, 1, 1, 1) // replace table[row] with -> newArray
        }
    }

    for (ro in multiDimenArray) { // for each row in table
        println("freplacing second row w 111  ${ro.contentToString()}") // print row
    }

    for (ro in 0..multiDimenArray.size - 1) { // for each row in table
        for (col in 0..multiDimenArray[ro].size - 1) { // for col in row
            multiDimenArray[multiDimenArray.size - 1] = intArrayOf(0, 0, 0, 0) // last row is 0000
        }

        for (ro in multiDimenArray) { // for each row in table
            println(" replace last row edit in marray ${ro.contentToString()}") // print elements in row
        }

        // totalts sum of all elements in table
        var tableSum = 0
        for (ro in 0..multiDimenArray.size - 1) { // for each row in table
            for (col in 0..multiDimenArray[ro].size - 1) { // for each col in the row
                tableSum += multiDimenArray[ro][col] // sum each elemetn
            }
        }
        println("SUM OF  ROW ${tableSum}")

        var lastRowSum = 0
        for (row in 0..multiDimenArray.size - 1) {
            for (col in 0..multiDimenArray[2].size - 1) {
                lastRowSum += multiDimenArray[2][col]
                println("last row sum  0 0 - ${lastRowSum}")
            }
        }


//                for (row in 0..multiDimenArray.size - 1) { // for each row in table
//                    println("row number ${row}") // print row number [index]
//                    for (col in 0..multiDimenArray[row].size - 1) {
//                        println("each element in  ${multiDimenArray[row][col]}") // print each element in the row
//                        println()
//                    }
//                    for (j in i.)


        val array1 = intArrayOf(4,2,3,4)
        val array2 = intArrayOf(5,6,7,8)
        val array3 = intArrayOf(10, 11, 12, 14)

        val grades = arrayOf(array1, array2, array3)

        var lowestGrade = 1

        //looks for lowest grade
        for(grade in 0.. grades.size -1 ){ // for each row in grade table
            for(theGrade in grades[grade]){ // for each col in row
                if(theGrade < lowestGrade) { // if it is greater than lowest grade it is the lowest grade
                    lowestGrade = theGrade
                }
            }
        }


        println(lowestGrade)


    }

    val test1 = intArrayOf(4,2,3,4)
    val test2 = intArrayOf(5,6,7,8)
    val test3 = intArrayOf(10, 11, 12, 14)

    val grades = arrayOf(test1, test2, test3)

    for (test in 0.. grades.size - 1 ) { // for each test
        println("Test ${test+1}") // print test
        for (student in 0 ..  grades.size ) { // for each student in grades
            print("Student ${student+1} Grade: ${grades[test][student]}, ") // print student and its grade
        }
    }
    println()


}




class Gradebook(private val grades: Array<Array<Int>>, private val className: String) {


}