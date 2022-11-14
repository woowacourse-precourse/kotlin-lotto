package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.roundToInt
import kotlin.system.exitProcess

fun main() {
    val size = getTotalLottoPrice()
    val lottos = createLottos(size)
    val correct = getAnswerLotto()
    val bonus = getBonusLotto()
    compareLottos(lottos, correct, bonus)
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
        numbers.sort()
        println(numbers)
        lottos.add(Lotto(numbers))
    }
    return lottos
}

fun getAnswerLotto(): List<Int> {
    try {
        println("당첨 번호를 입력해주세요.")
        val correct = readLine()
            ?.split(',')
            ?.map { it.toInt() }
            ?.toMutableList() ?: throw IllegalArgumentException()
        if (correct.size != 6 || correct.distinct().size != 6
            || !correct.all { it in 1..46 }) throw IllegalArgumentException()
        println()
        return correct
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
fun compareLottos(lottos: List<Lotto>, correct: List<Int>, bonus: Int){
    var totalPrice = 0
    for (lotto in lottos){
        lotto.compareLotto(correct, bonus)
        totalPrice += lotto.getTotalPrice()
    }
    println("당첨통계\n---")
    for (i in LottoEnum.values()){
        println("${i.message} - ${i.count}개")
    }
    var profitRate = totalPrice/(lottos.size*1000.0)
    profitRate = (profitRate*10.0.roundToInt())/10.0
    println("총 수익률은 ${profitRate}%입니다.")
}