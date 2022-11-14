package lotto

import lotto.LottoPhrases.BONUS_LOTTO_NUMBER_PHRASES
import lotto.LottoPhrases.EARNING_RATE
import lotto.LottoPhrases.EARNING_RATE_END
import lotto.LottoPhrases.LOTTO_COUNT_PHRASES
import lotto.LottoPhrases.MAIN_LOTTO_NUMBERS_PHRASES
import lotto.LottoPhrases.PRIZE_GRADE_FIFTH
import lotto.LottoPhrases.PRIZE_GRADE_FIRST
import lotto.LottoPhrases.PRIZE_GRADE_FOURTH
import lotto.LottoPhrases.PRIZE_GRADE_SECOND
import lotto.LottoPhrases.PRIZE_GRADE_THIRD
import lotto.LottoPhrases.PRIZE_GRADE_UNIT
import lotto.LottoPhrases.PRIZE_STATISTICS_PHRASES
import lotto.LottoPhrases.PURCHASE_AMOUNT_PHRASES
import lotto.LottoRule.LOTTO_PRICE
import lotto.bank.Bank
import lotto.bank.Grade
import lotto.lottoshop.LottoShop
import lotto.lottoshop.lottomachine.LottoMachine

class GameHost(
    private val customer: Customer,
    private val lottoShop: LottoShop,
    private val lottoMachine: LottoMachine,
    private val bank: Bank
) {
    private lateinit var lottos: List<Lotto>

    fun progressPurchaseAmount() {
        printPurchaseAmountPhrases()
        val unprocessedPurchaseAmount = customer.getPurchaseAmount()
        val processedPurchaseAmount = lottoShop.getValidatePurchaseAmount(unprocessedPurchaseAmount)
        Customer.updatePurchaseAmount(processedPurchaseAmount)
        println()
    }

    private fun printPurchaseAmountPhrases() {
        println(PURCHASE_AMOUNT_PHRASES)
    }

    fun progressDrawLotto() {
        printLottoCountPhrases()
        lottos = drawLottos()
        printLottos(lottos)
    }

    private fun printLottoCountPhrases() {
        println((Customer.purchaseAmount / LOTTO_PRICE).toString() + LOTTO_COUNT_PHRASES)
    }

    private fun drawLottos(): List<Lotto> {
        var lottos = listOf<Lotto>()
        for (purchaseCount in 1..Customer.purchaseAmount / LOTTO_PRICE) lottos += lottoMachine.drawLotto()
        return lottos
    }

    private fun printLottos(lottos: List<Lotto>) {
        for (lotto in lottos) println(lotto.getLottoNumbers())
    }

    fun progressMainLottoNumbers() {
        printMainLottoNumbersPhrases()
        val unprocessedMainLottoNumbers = customer.getMainLottoNumbers()
        val processedMainLottoNumbers = lottoShop.getValidateMainLottoNumbers(unprocessedMainLottoNumbers)
        Customer.updateMainLottoNumbers(processedMainLottoNumbers)
        println()
    }

    private fun printMainLottoNumbersPhrases() {
        println(MAIN_LOTTO_NUMBERS_PHRASES)
    }

    fun progressBonusLottoNumber() {
        printBonusLottoNumberPhrases()
        val unprocessedBonusLottoNumber = customer.getBonusLottoNumber()
        val processedBonusLottoNumbers = lottoShop.getValidateBonusLottoNumber(unprocessedBonusLottoNumber)
        Customer.updateBonusLottoNumber(processedBonusLottoNumbers)
        lottoShop.checkLottoNumberDuplicate(Customer.mainLottoNumbers + Customer.bonusLottoNumber)
        println()
    }

    private fun printBonusLottoNumberPhrases() {
        println(BONUS_LOTTO_NUMBER_PHRASES)
    }

    fun progressBankService() {
        printPrizeStatisticsPhrases()
        calcPrizeGrades()
        bank.calcEarningRate(Customer.purchaseAmount, bank.prizeGrades)
        printPrizeGrades()
        printEarningRate()
    }

    private fun printPrizeStatisticsPhrases() {
        println(PRIZE_STATISTICS_PHRASES)
    }

    private fun calcPrizeGrades() {
        for (lotto in lottos) bank.calcPrizeGrade(Customer.mainLottoNumbers, Customer.bonusLottoNumber, lotto)
    }

    private fun printPrizeGrades() {
        println(PRIZE_GRADE_FIFTH + bank.prizeGrades[Grade.FIFTH.prizeGradesIndex] + PRIZE_GRADE_UNIT)
        println(PRIZE_GRADE_FOURTH + bank.prizeGrades[Grade.FOURTH.prizeGradesIndex] + PRIZE_GRADE_UNIT)
        println(PRIZE_GRADE_THIRD + bank.prizeGrades[Grade.THIRD.prizeGradesIndex] + PRIZE_GRADE_UNIT)
        println(PRIZE_GRADE_SECOND + bank.prizeGrades[Grade.SECOND.prizeGradesIndex] + PRIZE_GRADE_UNIT)
        println(PRIZE_GRADE_FIRST + bank.prizeGrades[Grade.FIRST.prizeGradesIndex] + PRIZE_GRADE_UNIT)
    }

    private fun printEarningRate() {
        println(EARNING_RATE + String.format("%.2f", bank.earningRate) + EARNING_RATE_END)
    }
}
