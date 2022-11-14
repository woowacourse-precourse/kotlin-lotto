package lotto

import kotlin.io.readLine

fun userbuy() : Int{
    var buing : Int = 0
    var howmany : Int = 0
    println("구입금액을 입력해주세요.")
    buing = readLine()!!.toIntOrNull() ?: 0
    if (buing < 1000 || buing % 1000 != 0) throw  IllegalArgumentException ("[ERROR]")
    if(buing == null) throw IllegalArgumentException ("[ERROR]")
    howmany = buing / 1000
    return(howmany)
}

fun inputnum() : List<Int>{
    var inputlotto  : List<Int> = List(7) {0}
    println("당첨 번호를 입력해 주세요.")
    inputlotto = readLine()!!.split(",").map { it.toIntOrNull() ?: 0 }
    if(inputlotto.size != inputlotto.distinct().size) throw IllegalArgumentException ("[ERROR]")
    if(inputlotto.size > 6 ) throw IllegalArgumentException ("[ERROR]")
    for( i : Int in 0 .. 5 step(1))
        if(!(inputlotto[i] > 0 && inputlotto[i] <46)) throw IllegalArgumentException ("[ERROR]")
    println("보너스 번호를 입력해 주세요.")
    inputlotto += readLine()!!.toIntOrNull() ?: 0
    if(inputlotto.contains(0)) throw IllegalArgumentException ("[ERROR]")
    if(inputlotto.size != inputlotto.distinct().size) throw IllegalArgumentException ("[ERROR]")
    for( i : Int in 0 .. 6 step(1))
        if(!(inputlotto[i] > 0 && inputlotto[i] <46)) throw IllegalArgumentException ("[ERROR]")
    return (inputlotto)
    }
    