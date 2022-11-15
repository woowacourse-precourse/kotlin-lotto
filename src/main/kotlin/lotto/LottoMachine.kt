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
import net.bytebuddy.implementation.InvokeDynamic.WithImplicitArguments

class LottoMachine {

    private lateinit var results: Results

    fun start() {

        val paymentInput = View.getPaymentAmount()
        val numberOfLotto = getNumberOfLottos(paymentInput)

        val lottos = generateLottos(numberOfLotto)

        View.printNumberOfLottos(numberOfLotto)
        View.printLottos(lottos)

        val winningLotto = convertNumbersToLotto(View.getWinningNumber())

        val bonusNumber = getBonusNumber(View.getBonusNumber())
        checkBonusNumberException(winningLotto, bonusNumber)

        results = Results(numberOfLotto)
        results.calculateResult(lottos, winningLotto, bonusNumber)

        View.printResultStats(results)
    }

    fun getNumberOfLottos(payment: String): Int {
        checkPaymentException(payment)
        return payment.toInt() / LOTTO_PRICE
    }

    fun checkPaymentException(payment: String) {
        try {
            payment.toInt()
        } catch (e: IllegalArgumentException) {
            println(NUMBER_INPUT_ERROR)
            throw NoSuchElementException(NUMBER_INPUT_ERROR)
        }
        if (payment.toInt() % LOTTO_PRICE != 0) {
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

}