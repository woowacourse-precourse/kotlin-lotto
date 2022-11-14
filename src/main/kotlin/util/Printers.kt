package util

import lotto.domain.Lotto
import lotto.domain.Rating
import lotto.domain.Rating.Companion.convertNumbers

import util.Messages.AMOUNT_LOTTO_MESSAGE
import util.Messages.BONUS_NUMBER_INPUT_MESSAGE
import util.Messages.RESULT_STATISTIC_MESSAGE
import util.Messages.USER_INPUT_MESSAGE
import util.Messages.WINNING_NUMBER_INPUT_MESSAGE

object Printers {

    // 로또 결과 출력
    fun lottoResult(result: List<Int>, rate: String) {
        println(RESULT_STATISTIC_MESSAGE)
        println("${Rating.THREE.matches}개 일치 (${Rating.THREE.winningAmount.convertNumbers()}원) - ${result[4]}개")
        println("${Rating.FOUR.matches}개 일치 (${Rating.FOUR.winningAmount.convertNumbers()}원) - ${result[3]}개")
        println("${Rating.FIVE.matches}개 일치 (${Rating.FIVE.winningAmount.convertNumbers()}원) - ${result[2]}개")
        println("${Rating.FIVE_AND_BONUS.matches}개 일치, 보너스 볼 일치 (${Rating.FIVE_AND_BONUS.winningAmount.convertNumbers()}원) - ${result[1]}개")
        println("${Rating.SIX.matches}개 일치 (${Rating.SIX.winningAmount.convertNumbers()}원) - ${result[0]}개")
        println("총 수익률은 ${rate}%입니다.")
    }
    // 로또 구매할 금액 문구 출력
    fun userInputMoney() {
        println(USER_INPUT_MESSAGE)
    }

    // 구매한 로또들 출력
    fun lottoList(list: List<Lotto>) {
        nextLine()
        println("${list.size}" + AMOUNT_LOTTO_MESSAGE)
        list.forEach { lotto ->
            println(lotto.getOrderedNumbers())
        }
        nextLine()
    }

    // 당첨 번호 입력 출력
    fun inputWinningNumber() {
        println(WINNING_NUMBER_INPUT_MESSAGE)
    }

    // 보너스 번호 입력 출력
    fun inputBonusNumber() {
        println(BONUS_NUMBER_INPUT_MESSAGE)
    }

    fun nextLine() {
        println()
    }
}