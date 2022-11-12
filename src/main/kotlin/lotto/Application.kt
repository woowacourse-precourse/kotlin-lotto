package lotto
import camp.nextstep.edu.missionutils.Randoms

fun createLottoNum(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6)
}
fun main() {
    val numbers = createLottoNum()
    val numbers2 = listOf<Int>(1,2,3,4,5,5)
    println(numbers)
    Lotto(numbers)
    Lotto(numbers2)

}
