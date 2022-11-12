package lotto
import camp.nextstep.edu.missionutils.Randoms

fun createLottoNum(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6)
}
fun main() {
    val numbers = createLottoNum()
    Lotto(numbers)
}
