package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val INTRODUCE_MESSAGE = "구입금액을 입력해 주세요."
const val SUCCESS_BUY_LOTTO_MESSAGE = "개를 구매했습니다."
const val WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요."
fun main() {
    displayIntroduceGuideMessage()
    val userBudget = getUserBudget()

    val boughtLottoCount = userBudget.toInt() / 1000
    displaySuccessBuyLottoGuideMessage(boughtLottoCount)
    val lottoTickets = getLottoTickets(boughtLottoCount)

    displayWinningNumbersInputGuideMessage()
    val winningNumbers = getWinningNumbers()
}

fun getUserBudget(): String = Console.readLine()
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

fun displayIntroduceGuideMessage() = println(INTRODUCE_MESSAGE)
fun displaySuccessBuyLottoGuideMessage(boughtLottoCount: Int) = println("$boughtLottoCount$SUCCESS_BUY_LOTTO_MESSAGE")
fun displayCurrentLottoNumbers(currentLotto: Lotto) = println(currentLotto.getSortedNumbers())
fun displayWinningNumbersInputGuideMessage() = println(WINNING_NUMBERS_INPUT_MESSAGE)