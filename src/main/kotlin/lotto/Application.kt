package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val INTRODUCE_MESSAGE = "구입금액을 입력해 주세요."
const val SUCCESS_BUY_LOTTO_MESSAGE = "개를 구매했습니다."
const val WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요."
const val WINNING_BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요."
const val RESULT_TITLE_MESSAGE = "당첨 통계"
const val RESULT_HORIZONTAL_LINE_MESSAGE = "---"

const val ERROR_MESSAGE = "[ERROR]"
const val ERROR_MESSAGE_BUDGET_INPUT = "$ERROR_MESSAGE 잘못된 구입금액을 입력하였습니다."
fun main() {
    displayIntroduceGuideMessage()
    val userBudget = getUserBudget()
    if (isWrongBudget(userBudget))
        return

    val boughtLottoCount = userBudget.toInt() / 1000
    displaySuccessBuyLottoGuideMessage(boughtLottoCount)
    val lottoTickets = getLottoTickets(boughtLottoCount)

    displayWinningNumbersInputGuideMessage()
    val winningNumbers = getWinningNumbers()

    displayWinningBonusNumberInputGuideMessage()
    val winningLottoBonusNumber = getWinningBonusNumber()

    displayResultGuideMessage()
}

fun getUserBudget(): String = Console.readLine()
fun isWrongBudget(userBudget: String): Boolean {
    return try {
        if (isNotInteger(userBudget))
            throw IllegalArgumentException(ERROR_MESSAGE_BUDGET_INPUT)

        if (userBudget.toInt() % 1000 != 0)
            throw IllegalArgumentException(ERROR_MESSAGE_BUDGET_INPUT)

        if (userBudget.toInt() < 0)
            throw IllegalArgumentException(ERROR_MESSAGE_BUDGET_INPUT)

        false
    } catch (e: IllegalArgumentException) {
        println(ERROR_MESSAGE_BUDGET_INPUT)
        true
    }
}

fun getLottoTickets(boughtLottoCount: Int): List<Lotto> {
    val lottoTickets = mutableListOf<Lotto>()
    for (i in 0 until boughtLottoCount) {
        val currentLotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        displayCurrentLottoNumbers(currentLotto)
        lottoTickets.add(currentLotto)
    }
    return lottoTickets
}

fun getWinningNumbers() = Console.readLine().split(",").toMutableList()
fun getWinningBonusNumber(): String = Console.readLine()

fun displayIntroduceGuideMessage() = println(INTRODUCE_MESSAGE)
fun displaySuccessBuyLottoGuideMessage(boughtLottoCount: Int) = println("$boughtLottoCount$SUCCESS_BUY_LOTTO_MESSAGE")
fun displayCurrentLottoNumbers(currentLotto: Lotto) = println(currentLotto.getSortedNumbers())
fun displayWinningNumbersInputGuideMessage() = println(WINNING_NUMBERS_INPUT_MESSAGE)
fun displayWinningBonusNumberInputGuideMessage() = println(WINNING_BONUS_NUMBER_INPUT_MESSAGE)
fun displayResultGuideMessage() = run {
    println(RESULT_TITLE_MESSAGE)
    println(RESULT_HORIZONTAL_LINE_MESSAGE)
}

fun isNotInteger(string: String): Boolean {
    return try {
        string.toInt()
        false
    } catch (e: NumberFormatException) {
        true
    }
}