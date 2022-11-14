package lotto.controller

import lotto.domain.Generator
import lotto.domain.Lotto
import lotto.domain.ProfitCalculator
import lotto.domain.Rank
import lotto.utils.validation.*
import lotto.view.Input
import lotto.view.Output

class LottoShop(
    private val input: Input,
    private val output: Output,
    private val generator: Generator,
    private val ranks: List<Rank>,
    private val profitCalculator: ProfitCalculator
) {
    private var money = 0
    private val tickets = mutableListOf<Lotto>()
    private lateinit var winningNumbers: List<Int>
    private var bonusNumber = 0
    private val totalRanks = MutableList(Rank.values().size) { 0 }

    fun announceYield() {}

    fun announceWinners() {}

    fun publish() {
        getMoney()
    }

    private fun getMoney() {
        val userInput = input.getMoney()
        val userInputVerifiers = listOf(
            IntegerVerifier()
        )
        checkInputValid(userInput, userInputVerifiers)

        val moneyVerifiers = listOf(
            PositiveNumberVerifier(),
            DivisibilityVerifier(DIVISOR)
        )
        checkInputValid(userInput.toInt(), moneyVerifiers)
        money = userInput.toInt()
    }

    private fun <T> checkInputValid(input: T, verifiers: List<Verifier<T>>) {
        val inputValidator = InputValidator(verifiers)
        inputValidator.validate(input)
    }

    private fun printTickets() {}

    private fun printWinners() {}

    private fun printYield(yield: Double) {}

    private fun setBonusNumber() {}

    private fun setWinningNumbers() {}

    companion object {
        const val DIVISOR = 1000
    }
}