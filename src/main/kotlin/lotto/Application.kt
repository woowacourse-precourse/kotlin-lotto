package lotto

import kotlin.io.readLine

fun userbuy() : Int{
    var buing : Int
    var howmany : Int
    println("구입금액을 입력해주세요.")
    buing = readLine()!!.toIntOrNull() ?: 0
    if (buing < 1000 || buing % 1000 != 0) throw  IllegalArgumentException ("[ERROR]")
    if(!(buing != 0)) throw IllegalArgumentException ("[ERROR]")
    howmany = buing / 1000
    return(howmany)
}

fun inputnum() : List<Int>{
    //var inputlotto  : MutableList<Int> = MutableList(7) { 0 }
    println("당첨 번호를 입력해 주세요.")
    var inputlotto = readLine()!!.split(",").map { it.toIntOrNull() ?: 0 }
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
fun makeLottonumber(frLottonum : MutableList <Int>) : MutableList <Int> {
    frLottonum.removeAt(6)
    return (frLottonum)
}

fun checknum(inputnum : List<Int>, frLottonum : MutableList <Int>) : Int
{
    var checker = 0
    for (i in 0..5 step(1))
        for (j in 0..5 step(1)) checker += checknum02(inputnum[i], frLottonum[j])
    return checker
}
fun checknum02(i : Int, j : Int) : Int
{
    var checker = 0
    if (i == j){
        checker++;
    }
    return checker
}
fun  getnumber2(count: MutableList<Int>, prizemoney : Int) : Int{
    var PrizeMoney = prizemoney
    when  {
        (count[6] != 0) -> PrizeMoney += 2000000000
        (count[5] != 0) -> PrizeMoney += 1500000//3등
        (count[4] != 0) -> PrizeMoney += 50000
        (count[3] != 0) -> PrizeMoney += 5000
        else -> PrizeMoney += 0
    }
    return PrizeMoney
}
fun  comparlotto(inputlotto : List<Int>, lottonum : MutableList<MutableList<Int>>) : Pair<Int,MutableList<Int>> {
    var prizemoney :Int = 0
    var count = MutableList<Int>(7) {0}
    var frLottonum = makeLottonumber(inputlotto.toMutableList())
    for (i : Int in 0..lottonum.size-1) {
        count[checknum(lottonum[i], frLottonum)] += 1
        prizemoney += getnumber2(count, prizemoney)
    }
    return Pair(prizemoney,count)
}
fun comparlotto2(inputlotto : List<Int>, lottonum : MutableList<MutableList<Int>>) : Pair<Int,Int>{
    var prizemoney2: Int = 0
    var count2 : Int = 0
    var count = MutableList<Int>(7) {0}
  //  var sedLottonum = makeLottonumber2(inputlotto.toMutableList())
    for (i: Int in 0..lottonum.size - 1) {
        var tmp = count[5]
        count [checknum(lottonum[i], inputlotto.toMutableList())]+=1
        if ( count[5] - tmp == 1) {
            prizemoney2 += 30000000
            count2+=1
            count[1] += 1
        }
    }
    return Pair(prizemoney2, count2)
}
fun main() {
    var lottonum : MutableList<MutableList<Int>> = mutableListOf()
    var howmany   = userbuy()
    println("${howmany}개를 구매했습니다.")

    for(i : Int in 0..howmany-1 step(1)){
        lottonum.add(getComputerInput())
        println("${lottonum[i]}")
    }
    var inputlottonum = inputnum()
    var(prizemoney2, count2) = comparlotto2(inputlottonum, lottonum)
    var (prizemoney, count) = comparlotto(inputlottonum, lottonum)

    for(i in 0 .. lottonum.size -1 step(1)) {
        //if (inputlottonum[6] in lottonum[i] ) {
        if (lottonum[i].contains(inputlottonum[6])) {
           // var(prizemoney2, count2) = comparlotto2(inputlottonum, lottonum)
            prizemoney += prizemoney2
            count[1] += count2
        }
    }
    //var tmp = count[4]
    if(count[1] > 0) count[5] -=count[1]
    println("당첨 통계")
    println("3개 일치 (5,000원) - ${count[3]}개")
    println("4개 일치 (50,000원) - ${count[4]}개")
    println("5개 일치 (1,500,000원) - ${count[5]}개")
//    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${count2}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${count[1]}개")
    println("6개 일치 (2,000,000,000원) - ${count[6]}개")
    println("총 수익률은 ${prizemoney / (howmany*10)}%입니다.")
}
