package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.util.regex.Pattern

private const val amount = 1000
fun main() {
    setLotto(getSellLottoCount())

}
private fun getSellLottoCount() : Int {

    println("구입금액을 입력해 주세요.")

    val input = readLine()!!

    // 예외 처리
    if (!Pattern.matches("^[0-9]*", input) || (input.toInt() % amount) != 0 || (input.toInt() / amount) == 0) {
        throw IllegalArgumentException("[ERROR] 정확한 로또 금액을 입력해 주세요.")
    }

    val lottoAmount = input.toInt() / amount
    println("${lottoAmount}개를 구매했습니다.")

    return lottoAmount

}

private fun setLotto(count: Int) {
    var lottos = mutableListOf<Lotto>()

    for(i in 0 until count){
        val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        lottos.add(lotto)
        println(lotto.getLottoNumbers())
    }
}

