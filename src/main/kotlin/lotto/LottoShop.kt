package lotto

import lotto.domain.Generator
import lotto.domain.Lotto
import lotto.domain.ProfitCalculator
import lotto.domain.Rank

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
        guideInputMoney()
        val userInput = input.get()
    }

    private fun <T> checkInputValid(input: T, verifiers: List<Verifier<T>>) {
        val inputValidator = InputValidator(verifiers)
        inputValidator.validate(input)
    }

    private fun guideInputMoney() {
        output.guideInputMoney()
    }

    private fun printTickets() {}

    private fun printWinners() {}

    private fun printYield(yield: Double) {}

    private fun setBonusNumber() {}

    private fun setWinningNumbers() {}
}