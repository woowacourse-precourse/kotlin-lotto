package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.util.regex.Pattern

private const val amount = 1000
fun main() {
    val winningNumber : MutableList<Int> = mutableListOf()
    setLotto(getSellLottoCount())
    getWinningNumber(winningNumber)
}
private fun getSellLottoCount() : Int {

    println("구입금액을 입력해 주세요.")

    val input = readLine()!!

    // 예외 처리
    if (!Pattern.matches("^[0-9]*", input) || (input.toInt() % amount) != 0 || (input.toInt() / amount) == 0) {
        throw IllegalArgumentException("[ERROR] 정확한 로또 금액을 입력해 주세요.")
    }

    val lottoAmount = input.toInt() / amount
    println("\n${lottoAmount}개를 구매했습니다.")

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

private fun getWinningNumber(winningNumber : MutableList<Int>){

    println("\n당첨 번호를 입력해 주세요.")

    val input = readLine()!!

    if(!Pattern.matches("^[0-9],[0-9],[0-9],[0-9],[0-9],[0-9]\$", input)) {
        throw IllegalArgumentException("[ERROR] 공백 없이 당첨 번호 6개를 모두 입력해 주세요.")
    }

    checkWinningNumberInputOverlapException(input).forEach {
        winningNumber.add(it.toInt())
    }

    //println(winningNumber)
}

private fun checkWinningNumberInputOverlapException(input: String) : MutableSet<String> {

    var str = input.split(',')
    var winningStr : MutableSet<String> = mutableSetOf() // LinkedHashSet 생성: 순서O 중복X

    str.forEach{
        winningStr.add(it)
    }

    when (winningStr.size) {

        6 -> return winningStr
        else -> { throw IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.") }

    }

}



