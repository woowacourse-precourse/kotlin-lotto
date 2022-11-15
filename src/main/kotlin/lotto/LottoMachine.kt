package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto.Companion.LOTTO_PRICE
import lotto.Lotto.Companion.LOTTO_SIZE
import lotto.Lotto.Companion.MAX_NUMBER
import lotto.Lotto.Companion.MIN_NUMBER
import lotto.Messages.Companion.DIVISION_ERROR
import lotto.Messages.Companion.DUPLICATE_NUMBER_ERROR
import lotto.Messages.Companion.NUMBER_INPUT_ERROR
import lotto.Messages.Companion.NUMBER_RANGE_ERROR

class LottoMachine {

    private lateinit var rankResults: MutableMap<WinningRank, Int>
    private var prizeMoney = 0.0

    fun start() {
        val paymentInput = View.getPaymentAmount()
        val numberOfLotto = getNumberOfLottos(paymentInput)

        val lottos = generateLottos(numberOfLotto)

        View.printNumberOfLottos(numberOfLotto)
        View.printLottos(lottos)

        val winningLotto = convertNumbersToLotto(View.getWinningNumber())

        val bonusNumber = getBonusNumber(View.getBonusNumber())
        checkBonusNumberException(winningLotto, bonusNumber)

        calculateResult(lottos, winningLotto, bonusNumber)
        val earningsRate = getEarningsRate(numberOfLotto)

        View.printResultStats(rankResults, earningsRate)
    }

    fun getNumberOfLottos(payment: String): Int {
        checkPaymentException(payment)
        return payment.toInt() / LOTTO_PRICE
    }

    fun checkPaymentException(payment: String) {
        var price = -1
        try {
            price = payment.toInt()
        } catch (e: IllegalArgumentException) {
            println(NUMBER_INPUT_ERROR)
            throw NoSuchElementException(NUMBER_INPUT_ERROR)
        }
        if (price % LOTTO_PRICE != 0) {
            println(DIVISION_ERROR)
            throw IllegalArgumentException(DIVISION_ERROR)
        }
    }

    fun generateLottos(numberOfLottos: Int): ArrayList<Lotto> {
        val lottos: ArrayList<Lotto> = arrayListOf()
        repeat(numberOfLottos) {
            lottos.add(generateLotto())
        }
        return lottos
    }

    fun generateLotto(): Lotto {
        val randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE).sorted()
        return Lotto(randomNumbers)
    }

    fun convertNumbersToLotto(numbers: String): Lotto {
        return Lotto(numbers.split(",").map { it.toInt() }.toList().sorted())
    }

    fun getBonusNumber(number: String): Int {
        try {
            return number.toInt()
        } catch (e: IllegalArgumentException) {
            println(NUMBER_INPUT_ERROR)
            throw NoSuchElementException(NUMBER_INPUT_ERROR)
        }
    }

    fun checkBonusNumberException(winningLotto: Lotto, number: Int) {
        if (number !in MIN_NUMBER..MAX_NUMBER) {
            throw IllegalArgumentException(NUMBER_RANGE_ERROR)
        }
        if (winningLotto.getNumbers().contains(number)) {
            throw IllegalArgumentException(DUPLICATE_NUMBER_ERROR)
        }
    }

    fun calculateResult(lottos: List<Lotto>, winningLotto: Lotto, bonusNumber: Int) {
        initializeResults()
        lottos.forEach { calculateLottoResult(it, winningLotto, bonusNumber) }
    }

    fun initializeResults() {
        rankResults = mutableMapOf()
        for (rank in WinningRank.values()) {
            rankResults[rank] = 0
        }
        prizeMoney = 0.0
    }

    fun calculateLottoResult(lotto: Lotto, winningLotto: Lotto, bonusNumber: Int) {
        val matchCount = lotto.getNumbers().count { winningLotto.getNumbers().contains(it) }
        val rank = when (matchCount) {
            6 -> WinningRank.FIRST
            5 -> {
                if (lotto.getNumbers().contains(bonusNumber)) {
                    WinningRank.SECOND
                } else {
                    WinningRank.THIRD
                }
            }
            4 -> WinningRank.FORTH
            3 -> WinningRank.FIFTH
            else -> WinningRank.NOTHING
        }
        prizeMoney += rank.prizeMoney
        rankResults[rank] = rankResults[rank]!!.plus(1)
    }

    fun getEarningsRate(numberOfLotto: Int): String {
        return String.format("%.1f", (prizeMoney / (numberOfLotto * LOTTO_PRICE)) * 100)
    }

}