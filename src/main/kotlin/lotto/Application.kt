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
const val ERROR_MESSAGE_RANDOM_NUMBER_LOTTO = "$ERROR_MESSAGE 잘못된 개수의 랜덤 로또 뽑기입니다."
const val ERROR_MESSAGE_RANDOM_NUMBER_LOTTO_COUNT = "$ERROR_MESSAGE 구입한 로또 개수와 실제로 뽑은 랜덤 로또 개수가 일치하지 않습니다."
fun main() {
    displayIntroduceGuideMessage()
    val userBudget = getUserBudget()
    if (isWrongBudget(userBudget))
        return

    val boughtLottoCount = userBudget.toInt() / 1000
    displaySuccessBuyLottoGuideMessage(boughtLottoCount)
    val lottoTickets = getLottoTickets(boughtLottoCount)
    if (isWrongLottoTicketCount(boughtLottoCount, lottoTickets))
        return

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
        if (isWrongCurrentLottoNumbers(currentLotto))
            return emptyList()
        displayCurrentLottoNumbers(currentLotto)
        lottoTickets.add(currentLotto)
    }
    return lottoTickets
}

fun isWrongCurrentLottoNumbers(currentLotto: Lotto): Boolean {
    return try {
        if (currentLotto.getSortedNumbers().toSet().size != 6) {
            throw IllegalArgumentException(ERROR_MESSAGE_RANDOM_NUMBER_LOTTO)
        }
        if (currentLotto.getSortedNumbers().map { it !in 1..45 }.contains(true)) {
            throw IllegalArgumentException(ERROR_MESSAGE_RANDOM_NUMBER_LOTTO)
        }
        false
    } catch (e: IllegalArgumentException) {
        println(ERROR_MESSAGE_RANDOM_NUMBER_LOTTO)
        true
    }
}

fun isWrongLottoTicketCount(boughtLottoCount: Int, lottoTickets: List<Lotto>): Boolean {
    return try {
        if (boughtLottoCount != lottoTickets.size)
            throw IllegalArgumentException(ERROR_MESSAGE_RANDOM_NUMBER_LOTTO_COUNT)
        false
    } catch (e: IllegalArgumentException) {
        println(ERROR_MESSAGE_RANDOM_NUMBER_LOTTO_COUNT)
        true
    }
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