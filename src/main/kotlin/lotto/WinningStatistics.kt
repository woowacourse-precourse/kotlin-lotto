package lotto

import java.text.DecimalFormat
import java.util.*

enum class WinningStatistics {
    THREE_WINNING_NUMBERS, FOUR_WINNING_NUMBERS, FIVE_WINNING_NUMBERS, FIVE_BONUS_WINNING_NUMBERS, SIX_WINNING_NUMBERS, TOTAL_RETURN_FORMAT
}

fun getWinningStatistics(
    winningStatistics: WinningStatistics, listOfNumberOfWinningNumbers: MutableList<Int>, purchaseAmount: Int = 0
): String {
    when (winningStatistics) {
        WinningStatistics.THREE_WINNING_NUMBERS -> return "3개 일치 (${setWinningNumbersCompensationFormat(BaseNumber.THREE_WINNING_NUMBERS_COMPENSATION.number)}) - ${
            Collections.frequency(
                listOfNumberOfWinningNumbers, BaseNumber.THREE.number
            )
        }개"

        WinningStatistics.FOUR_WINNING_NUMBERS -> return "4개 일치 (${setWinningNumbersCompensationFormat(BaseNumber.FOUR_WINNING_NUMBERS_COMPENSATION.number)}) - ${
            Collections.frequency(
                listOfNumberOfWinningNumbers, BaseNumber.FOUR.number
            )
        }개"

        WinningStatistics.FIVE_WINNING_NUMBERS -> return "5개 일치 (${setWinningNumbersCompensationFormat(BaseNumber.FIVE_WINNING_NUMBERS_COMPENSATION.number)}) - ${
            Collections.frequency(
                listOfNumberOfWinningNumbers, BaseNumber.FIVE.number
            )
        }개"

        WinningStatistics.FIVE_BONUS_WINNING_NUMBERS -> return "5개 일치, 보너스 볼 일치 (${
            setWinningNumbersCompensationFormat(
                BaseNumber.FIVE_WINNING_NUMBERS_AND_BONUS_COMPENSATION.number
            )
        }) - ${
            Collections.frequency(
                listOfNumberOfWinningNumbers, BaseNumber.FIVE_BONUS.number
            )
        }개"

        WinningStatistics.SIX_WINNING_NUMBERS -> return "6개 일치 (${setWinningNumbersCompensationFormat(BaseNumber.SIX_WINNING_NUMBERS_COMPENSATION.number)}) - ${
            Collections.frequency(
                listOfNumberOfWinningNumbers, BaseNumber.SIX.number
            )
        }개"

        WinningStatistics.TOTAL_RETURN_FORMAT -> return "총 수익률은 ${
            setTotalReturnFormat(
                getTotalRevenue(
                    listOfNumberOfWinningNumbers
                ).toDouble(), purchaseAmount.toDouble()
            )
        }입니다. "
    }
}

fun setWinningNumbersCompensationFormat(winningNumbersCompensation: Int): String =
    DecimalFormat("#,###원").format(winningNumbersCompensation)