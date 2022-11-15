package lotto.controller

import lotto.domain.*
import lotto.utils.parser.NumbersSplitParser
import lotto.utils.validation.*
import lotto.view.Input
import lotto.view.Output

class LottoShop(
    private val input: Input,
    private val output: Output,
    private val lottoMachine: LottoMachine,
    private val parser: NumbersSplitParser,
    private val ranks: List<Rank>,
    private val profitCalculator: ProfitCalculator
) {
    private var money = 0
    private val tickets = mutableListOf<Lotto>()
    private lateinit var winningNumbers: List<Int>
    private var bonusNumber = 0
    private val totalRanks = MutableList(Rank.values().size) { 0 }

    fun announceYield() {
        val totalPrize = profitCalculator.calculateTotalPrize(ranks, totalRanks)
        val yieldPercentage = profitCalculator.calculateYield(totalPrize, money)
        printYield(yieldPercentage)
    }

    fun announceWinners() {
        setWinningNumbers()
        setBonusNumber()

        val lottoRanks = tickets.map { lotto -> lotto.getRank(winningNumbers, bonusNumber) }
        lottoRanks.filterNotNull()
            .map { rank -> totalRanks[rank.ordinal]++ }

        printWinners()
    }

    fun publish() {
        getMoney()
        tickets.addAll(lottoMachine.publish(money))
        printTickets()
    }

    private fun getMoney() {
        val userInput = input.getMoney()
        val userInputVerifiers = listOf(
            IntegerVerifier()
        )
        checkInputValid(userInput, userInputVerifiers)

        money = userInput.toInt()
        val moneyVerifiers = listOf(
            PositiveNumberVerifier(),
            DivisibilityVerifier(DIVISOR)
        )
        checkInputValid(money, moneyVerifiers)
    }

    private fun <T> checkInputValid(input: T, verifiers: List<Verifier<T>>) {
        val inputValidator = InputValidator(verifiers)
        inputValidator.validate(input)
    }

    private fun printTickets() {
        output.printTickets(tickets.map { lotto -> lotto.getTicket() })
    }

    private fun printWinners() {
        output.printWinners(ranks.reversed(), totalRanks.reversed())
    }

    private fun printYield(yieldPercentage: String) {
        output.printYield(yieldPercentage)
    }

    private fun setBonusNumber() {
        val userInput = input.getBonusNumber()
        val userInputVerifiers = listOf(
            IntegerVerifier()
        )
        checkInputValid(userInput, userInputVerifiers)

        bonusNumber = userInput.toInt()
        val bonusNumberVerifiers = listOf(
            RangeVerifier(NUMBER_MIN, NUMBER_MAX),
            UniquenessVerifier(winningNumbers)
        )
        checkInputValid(bonusNumber, bonusNumberVerifiers)
    }

    private fun setWinningNumbers() {
        val userInput = input.getWinningNumbers()
        val parsedUserInput = parser.parse(userInput)
        val parsedUserInputVerifiers = listOf(
            IntegersVerifier()
        )
        checkInputValid(parsedUserInput, parsedUserInputVerifiers)

        winningNumbers = parsedUserInput.map { number -> number.toInt() }
        val winningNumbersVerifiers = listOf(
            ListSizeVerifier(WINNING_NUMBER_COUNT),
            RangesVerifier(NUMBER_MIN, NUMBER_MAX),
            DistinctVerifier()
        )
        checkInputValid(winningNumbers, winningNumbersVerifiers)
    }

    companion object {
        const val DIVISOR = 1000
        const val WINNING_NUMBER_COUNT = 6
        const val NUMBER_MIN = 1
        const val NUMBER_MAX = 45
    }
}