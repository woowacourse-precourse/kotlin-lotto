package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.text.DecimalFormat
import kotlin.IllegalArgumentException

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
const val ERROR_MESSAGE_WINNING_NUMBERS_INPUT = "$ERROR_MESSAGE 잘못된 로또 당첨번호 입력입니다."
const val ERROR_MESSAGE_BONUS_NUMBER_INPUT = "$ERROR_MESSAGE 잘못된 보너스 번호 입력입니다."
const val ERROR_MESSAGE_WINNING_NUMBER_FINAL_INPUT = "$ERROR_MESSAGE 각각 다른 당첨번호 및 보너스 번호를 작성해주세요."

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
    if (isWrongWinningNumbers(winningNumbers))
        return

    displayWinningBonusNumberInputGuideMessage()
    val winningLottoBonusNumber = getWinningBonusNumber()
    if (isWrongWinningBonusNumber(winningLottoBonusNumber))
        return

    val winningLotto = getWinningLotto(winningNumbers, winningLottoBonusNumber)
    if (isWrongWinningLotto(winningLotto))
        return

    displayResultGuideMessage()
    val matchedLottoTickets =
        getRankedLotto(lottoTickets, winningLotto.map { it.toInt() }, winningLottoBonusNumber.toInt())
    val totalPrizeAmount = getTotalPrizeAmount(matchedLottoTickets)
    displayResultPrize(matchedLottoTickets)
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
fun isWrongWinningNumbers(winningNumbers: List<String>): Boolean {
    return try {
        for (winningNumber in winningNumbers) {
            if (isNotInteger(winningNumber)) {
                throw IllegalArgumentException(ERROR_MESSAGE_WINNING_NUMBERS_INPUT)
            }
            if (winningNumber.toInt() !in 1..45) {
                throw IllegalArgumentException(ERROR_MESSAGE_WINNING_NUMBERS_INPUT)
            }
        }
        false
    } catch (e: IllegalArgumentException) {
        println(ERROR_MESSAGE_WINNING_NUMBERS_INPUT)
        true
    }
}

fun getWinningBonusNumber(): String = Console.readLine()
fun isWrongWinningBonusNumber(winningBonusNumber: String): Boolean {
    return try {
        if (isNotInteger(winningBonusNumber))
            throw IllegalArgumentException(ERROR_MESSAGE_BONUS_NUMBER_INPUT)
        if (winningBonusNumber.toInt() !in 1..45)
            throw IllegalArgumentException(ERROR_MESSAGE_BONUS_NUMBER_INPUT)
        false
    } catch (e: IllegalArgumentException) {
        println(ERROR_MESSAGE_BONUS_NUMBER_INPUT)
        true
    }
}

fun getWinningLotto(winningNumbers: MutableList<String>, winningLottoBonusNumber: String): List<String> {
    winningNumbers.add(winningLottoBonusNumber)
    return winningNumbers
}

fun isWrongWinningLotto(winningLotto: List<String>): Boolean {
    return try {
        if (winningLotto.toSet().size != 7) {
            throw IllegalArgumentException(ERROR_MESSAGE_WINNING_NUMBER_FINAL_INPUT)
        }
        false
    } catch (e: IllegalArgumentException) {
        println(ERROR_MESSAGE_WINNING_NUMBER_FINAL_INPUT)
        true
    }
}

fun getRankedLotto(
    lottoTickets: List<Lotto>,
    winningLotto: List<Int>,
    winningLottoBonusNumber: Int
): MutableMap<Rank, Int> {
    val matchedLottoTickets = mutableMapOf<Rank, Int>()
    for (currentLotto in lottoTickets) {
        val currentLottoRanking = getLottoRanking(
            currentLotto,
            winningLotto as MutableList<Int>, winningLottoBonusNumber
        )
        if (currentLottoRanking != Rank.NON_RANKED)
            matchedLottoTickets[currentLottoRanking] = matchedLottoTickets.getOrPut(currentLottoRanking) { 0 } + 1
    }

    return matchedLottoTickets
}

fun getLottoRanking(currentLotto: Lotto, winningLotto: MutableList<Int>, bonusNumber: Int): Rank {
    val matchNumbers = currentLotto.getSortedNumbers().toSet().intersect(winningLotto.toSet())
    when (matchNumbers.size) {
        Rank.FIRST.matchNumbers -> return Rank.FIRST
        Rank.SECOND.matchNumbers -> {
            if (containsBonusNumber(currentLotto, bonusNumber)) Rank.SECOND
            return Rank.THIRD
        }
        Rank.THIRD.matchNumbers -> {
            if (containsBonusNumber(currentLotto, bonusNumber)) Rank.SECOND
            return Rank.THIRD
        }
        Rank.FOURTH.matchNumbers -> return Rank.FOURTH
        Rank.FIFTH.matchNumbers -> return Rank.FIFTH
    }
    return Rank.NON_RANKED
}

fun containsBonusNumber(currentLotto: Lotto, bonusLottoNumber: Int) =
    currentLotto.getSortedNumbers().contains(bonusLottoNumber)

fun getTotalPrizeAmount(matchedLottoTickets: MutableMap<Rank, Int>): Int {
    var totalPrizeAmount = 0
    for (ranking in Rank.values().reversed()) {
        if (ranking != Rank.NON_RANKED) {
            totalPrizeAmount += ranking.prizeMoney * matchedLottoTickets.getOrPut(ranking) { 0 }
        }
    }
    return totalPrizeAmount
}

fun displayIntroduceGuideMessage() = println(INTRODUCE_MESSAGE)
fun displaySuccessBuyLottoGuideMessage(boughtLottoCount: Int) = println("$boughtLottoCount$SUCCESS_BUY_LOTTO_MESSAGE")
fun displayCurrentLottoNumbers(currentLotto: Lotto) = println(currentLotto.getSortedNumbers())
fun displayWinningNumbersInputGuideMessage() = println(WINNING_NUMBERS_INPUT_MESSAGE)
fun displayWinningBonusNumberInputGuideMessage() = println(WINNING_BONUS_NUMBER_INPUT_MESSAGE)
fun displayResultGuideMessage() = run {
    println(RESULT_TITLE_MESSAGE)
    println(RESULT_HORIZONTAL_LINE_MESSAGE)
}

fun displayResultPrize(matchedLottoTickets: MutableMap<Rank, Int>) {
    for (ranking in Rank.values().reversed()) {
        if (ranking != Rank.NON_RANKED) {
            showCurrentRankingCount(ranking, matchedLottoTickets.getOrPut(ranking) { 0 })
        }
    }
}

fun showCurrentRankingCount(rank: Rank, matchedNumberCount: Int) {
    if (rank == Rank.SECOND) {
        println("${rank.matchNumbers}개 일치, 보너스 볼 일치 (${getNumberWithUnit(rank.prizeMoney)}원) - ${matchedNumberCount}개")
        return
    }
    println("${rank.matchNumbers}개 일치 (${getNumberWithUnit(rank.prizeMoney)}원) - ${matchedNumberCount}개")
}

fun getNumberWithUnit(number: Int): String = DecimalFormat("#,###").format(number)

fun isNotInteger(string: String): Boolean {
    return try {
        string.toInt()
        false
    } catch (e: NumberFormatException) {
        true
    }
}