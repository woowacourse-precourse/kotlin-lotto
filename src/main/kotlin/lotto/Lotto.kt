package lotto
import kotlin.collections.mutableListOf


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }
}
fun getComputerInput(): MutableList <Int> {
    var com_number = mutableListOf<Int>()
    while(com_number.size < 6){
        val num = (1..45).random()
        if(!com_number.contains(num)) com_number.add(num)
    }
    return com_number.sorted().toMutableList()
}
//fun makeLottonumber(frLottonum : MutableList <Int>) : MutableList <Int> {
//    frLottonum.removeAt(6)
//    return (frLottonum)
//}
//fun makeLottonumber2(sedLottonum : MutableList <Int>) : MutableList <Int>{
//    sedLottonum.removeAt(5)
//    return (sedLottonum)
//}
//fun checknum(inputnum : List<Int>, frLottonum : MutableList <Int>) : Int
//{
//    var checker = 0
//    for (i in 0..5 step(1))
//        for (j in 0..5 step(1)) checker += checknum02(inputnum[i], frLottonum[j])
//    return checker
//}
//fun checknum02(i : Int, j : Int) : Int
//{
//    var checker = 0
//    if (i == j){
//        checker++;
//    }
//    return checker
//}
//fun  getnumber2(count: MutableList<Int>, prizemoney : Int) : Int{
//    var prizemoney = prizemoney
//    when  {
//        (count[6] != 0) -> prizemoney += 2000000000
//        (count[5] != 0) -> prizemoney += 1500000//3등
//        (count[4] != 0) -> prizemoney += 50000
//        (count[3] != 0) -> prizemoney += 5000
//        else -> prizemoney += 0
//    }
//    return prizemoney
//}
//fun  comparlotto(inputlotto : List<Int>, lottonum : MutableList<MutableList<Int>>) : Pair<Int,MutableList<Int>> {
//    var prizemoney :Int = 0
//    var count = MutableList<Int>(7) {0}
//    var frLottonum = makeLottonumber(inputlotto.toMutableList())
//    for (i : Int in 0..lottonum.size-1) {
//        count[checknum(lottonum[i], frLottonum)] += 1
//        prizemoney += getnumber2(count, prizemoney)
//    }
//    return Pair(prizemoney,count)
//}
//fun comparlotto2(inputlotto : List<Int>, lottonum : MutableList<MutableList<Int>>) : Pair<Int,Int>{
//    var prizemoney2: Int = 0
//    var count2 : Int = 0
//    var count = MutableList<Int>(7) {0}
//    var sedLottonum = makeLottonumber2(inputlotto.toMutableList())
//    for (i: Int in 0..lottonum.size - 1) {
//        var tmp = count[5]
//        count [checknum(lottonum[i], sedLottonum)]+=1
//        if ( count[5] - tmp == 1) {
//            prizemoney2 += 30000000
//            count2+=1
//        }
//    }
//    return Pair(prizemoney2, count2)
//}