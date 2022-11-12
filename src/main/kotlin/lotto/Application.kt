package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.util.regex.Pattern

private const val amount = 1000
fun main() {
    var winningNumber : MutableList<Int> = mutableListOf()
    var bonusNumber : Int

    setLotto(getSellLottoCount())
    getWinningNumber(winningNumber)
    bonusNumber = getBonusNumber(winningNumber)
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
    var checkedNumber : MutableList<Int>

    if(!Pattern.matches("^[0-9]*,[0-9]*,[0-9]*,[0-9]*,[0-9]*,[0-9]*\$", input)) {
        throw IllegalArgumentException("[ERROR] 공백 없이 입력해 주세요.")
    }

    checkedNumber = checkWinningNumberInputOvervalueException(checkWinningNumberInputOverlapException(input))
    winningNumber.addAll(checkedNumber)

    //println(winningNumber)
}

private fun checkWinningNumberInputOverlapException(input: String) : MutableSet<String> {

    var str = input.split(',')
    var winningSet : MutableSet<String> = mutableSetOf() // LinkedHashSet 생성: 순서O 중복X

    str.forEach{
        winningSet.add(it)
    }

    if(winningSet.size != 6){
        throw IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.")
    }

    return winningSet
}

private fun checkWinningNumberInputOvervalueException(input : MutableSet<String>) : MutableList<Int> {
    var winningInt : MutableList<Int> = mutableListOf()

    input.forEach {
        val num = it.toInt()
        if(num < 1 || num > 45){
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
        winningInt.add(num)
    }

    return winningInt
}

// 예외처리 리팩토링 필요
private fun getBonusNumber(winningNumber: MutableList<Int>) : Int {

    println("\n보너스 번호를 입력해 주세요.")

    val input = readLine()!!

    if(!Pattern.matches("^[0-9]*$", input)
        || input.toInt() < 1 || input.toInt() > 45
        || winningNumber.contains(input.toInt())){
        throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
    }

    return input.toInt()
}



