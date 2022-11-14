package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.system.exitProcess

fun main() {
    val size = getTotalLottoPrice()
    val lottos = createLottos(size)
}

fun getTotalLottoPrice(): Int {
    println("구입 금액을 입력해주세요.")
    try {
        val price = readLine()?.toInt() ?: throw IllegalArgumentException()
        if (price % 1000 != 0) throw IllegalArgumentException()
        println()
        return price/1000
    } catch(e: IllegalArgumentException) {
        println("[ERROR] 구입한 로또 가격 입력 오류")
        exitProcess(0)
    }
}

fun createLottos(size: Int): List<Lotto> {
    println("${size}개를 구매했습니다.")
    val lottos = mutableListOf<Lotto>()
    for (i in 1..size){
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        println(numbers)
        lottos.add(Lotto(numbers))
    }
    return lottos
}
