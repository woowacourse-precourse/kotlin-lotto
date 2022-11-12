package lotto
import camp.nextstep.edu.missionutils.Randoms

fun createLottoNum(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6)
}
fun createBonusNum(lottoNum:List<Int>):Int
{
    var remainder = (1..45).toMutableList()
    var ret :Int
    for(i in lottoNum) {
        if (remainder.contains(i))
            remainder.remove(i)
    }
    ret = Randoms.pickNumberInList(remainder)
    return ret
}
fun main() {
    val numbers = createLottoNum()
    val numbers2 = listOf<Int>(1,2,3,4,5,5)
    val bonus = createBonusNum(numbers)
    println(numbers)
    println(bonus)
    //Lotto(numbers)
    //Lotto(numbers2)

}
