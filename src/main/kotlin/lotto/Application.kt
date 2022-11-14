package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.system.exitProcess

fun main() {
    val size = getTotalLottoPrice()
    val lottos = createLottos(size)
    val answer = getAnswerLotto()
    val bonus = getBonusLotto()
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

fun getAnswerLotto(): List<Int> {
    try {
        println("당첨 번호를 입력해주세요.")
        val answer = readLine()
            ?.split(',')
            ?.map { it.toInt() }
            ?.toMutableList() ?: throw IllegalArgumentException()
        if (answer.size != 6 || answer.distinct().size != 6
            || !answer.all { it in 1..46 }) throw IllegalArgumentException()
        println()
        return answer
    } catch (e: IllegalArgumentException) {
        println("[ERROR] 로또 당첨 번호가 잘못 입력되었습니다.")
        exitProcess(0)
    }
}
fun getBonusLotto(): Int {
    try {
        println("보너스 번호를 입력해주세요.")
        val bonus = readLine()?.toInt() ?: throw IllegalArgumentException()
        if (bonus < 0 || bonus > 45)
            throw IllegalArgumentException()
        println()
        return bonus
    } catch (e: IllegalArgumentException) {
        println("[ERROR] 로또 보너스 번호가 잘못 입력되었습니다.")
        exitProcess(0)
    }
}
