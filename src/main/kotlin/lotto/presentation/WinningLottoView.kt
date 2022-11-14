package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto
import lotto.utils.BONUS_NUMBER_ENTER_MESSAGE
import lotto.utils.LottoExceptionHandler
import lotto.utils.Separator
import lotto.utils.WINNING_LOTTO_ENTER_MESSAGE

object WinningLottoView {
    fun printWinningLottoEnterMessage() {
        printEnter()
        println(WINNING_LOTTO_ENTER_MESSAGE)
    }

    fun inputWinningLottoNumbers(): WinningLotto {
        val numbers = Console.readLine().trim()
        val lottoNumbers = Separator.separateToInts(numbers, ',')
            .map { number -> LottoNumber(number) }
            .sortedBy { lottoNumber -> lottoNumber.number }

        return WinningLotto(lottoNumbers)
    }

    fun printBonusNumberEnterMessage() {
        printEnter()
        println(BONUS_NUMBER_ENTER_MESSAGE)
    }

    fun inputBonusNumber(): LottoNumber {
        val number = Console.readLine().trim()
        LottoExceptionHandler.validateIntType(number)

        return LottoNumber(number.toInt())
    }

    private fun printEnter() = println()
}