package com.alex.bean.kotlin

/**
 * Created by AlexHe on 2019-02-12.
 * Describe
 */

var selectedBox = ""

fun main(args: Array<String>) {
    println("\n===============Kotlin===============")
    val box3 = Box3()
    val box5 = Box5()
    var boxList = HashMap <String, Box>()
    boxList?.put("Box3", box3)
    boxList?.put("Box5", box5)
    var work = false

    println(
        "Please select box : \n" +
    " * Box3: 長23，寬14，高13 (cm)\n" +
    " * Box5: 長39.5，寬27.5，高23 (cm)"
    )
    //selectBox
    selectBox(work, boxList)
    //inputBoxInfo
    inputBoxInfo(work, boxList)
    println("成功寄出！")
}

private fun inputBoxInfo(work: Boolean, boxList: HashMap<String, Box>) {
    print("Please enter object's length: ")
    var length = readLine()?.toFloat()
    print("Please enter object's width: ")
    var width = readLine()?.toFloat()
    print("Please enter object's height: ")
    var height = readLine()?.toFloat()
    if (boxList[selectedBox]?.validate(length!!, width!!, height!!) == false) {
        selectBox(work, boxList)
        inputBoxInfo(work, boxList)
    }
}

private fun selectBox(work: Boolean, boxList: HashMap<String, Box>) {
    var work1 = work
    while (work1 == false) {
        selectedBox = readLine().toString()
        for (box in boxList!!.values) {
            if (selectedBox == box.getName()) {
                println("You selected: " + box.getName())
                work1 = true
            }
        }
        if (work1 == false) {
            println("Error, Please enter again.")
        }
    }
}

