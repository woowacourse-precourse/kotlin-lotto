package lottery

import lotto.Lotto
import camp.nextstep.edu.missionutils.Randoms
import data.NumberRange
import data.Price
import data.StringResource
import data.WinningAmount

class Lottery(private val purchase: Int, private val lotteryNumbers: Lotto, private val bonusNumber: Int) {
    private val winningCounter: MutableMap<String, Int> = mutableMapOf<String, Int>().withDefault { 0 }
    private val quickPicks: MutableList<Lotto> = mutableListOf()
    private var income: Double = 0.0
    private var incomeRatio: Double = 0.0

    init {
        require(purchase > 0 && purchase / Price.STANDARD.price == 0)
        require(bonusNumber in NumberRange.START.number..NumberRange.END.number)
        require(bonusNumber !in lotteryNumbers.getList())
        this.quickPicksGenerator()
        this.getWinnings()
        this.getIncomeRatio()
    }

    fun printQuickPick() {
        println(StringResource.TICKETS.resource.replace(
            StringResource.UNDERBAR.resource, this.quickPicks.size.toString()))

        this.quickPicks.forEach {
            println("[${it.getList().joinToString(separator = ", ")}]")
        }
    }

    private fun quickPicksGenerator() {
        val n = this.purchase / Price.STANDARD.price
        for (i in 0 until n){
            val numbers = Randoms.pickUniqueNumbersInRange(
                NumberRange.START.number, NumberRange.END.number, NumberRange.MAX.number)
            numbers.sort()
            this.quickPicks.add(Lotto(numbers))
        }

    }

    fun printWinnings() {
        println(StringResource.FIFTH.resource.replace(
            StringResource.UNDERBAR.resource, this.winningCounter.getValue("3").toString()))
        println(StringResource.FOURTH.resource.replace(
            StringResource.UNDERBAR.resource, this.winningCounter.getValue("4").toString()))
        println(StringResource.THIRD.resource.replace(
            StringResource.UNDERBAR.resource, this.winningCounter.getValue("5_0").toString()))
        println(StringResource.SECOND.resource.replace(
            StringResource.UNDERBAR.resource, this.winningCounter.getValue("5_1").toString()))
        println(StringResource.FIRST.resource.replace(
            StringResource.UNDERBAR.resource, this.winningCounter.getValue("6").toString()))
    }

    private fun getWinnings() {
        this.quickPicks.forEach {
            val rank = it.compareOriginal(this.lotteryNumbers)
            if (rank > 0 && rank != 5) {
                this.winningCounter[rank.toString()] = this.winningCounter.getValue(rank.toString()) + 1
                return@forEach
            }

            when (it.compareBonus(this.lotteryNumbers, this.bonusNumber)) {
                5 -> this.winningCounter["5_0"] = this.winningCounter.getValue("5_0") + 1
                6 -> this.winningCounter["5_1"] = this.winningCounter.getValue("5_1") + 1
            }
        }

    }

    fun printIncomeRatio() {
        this.incomeRatio = (this.income / this.purchase) * 100
        println(StringResource.RATIO.resource.replace(
            StringResource.UNDERBAR.resource, String.format("%.1f", this.incomeRatio)))
    }

    private fun getIncomeRatio() {
        this.winningCounter.forEach { (k, _) ->
            when (k) {
                "6" -> this.income += WinningAmount.FIRST.amount
                "5_1" -> this.income += WinningAmount.SECOND.amount
                "5_0" -> this.income += WinningAmount.THIRD.amount
                "4" -> this.income += WinningAmount.FOURTH.amount
                "3" -> this.income += WinningAmount.FIFTH.amount
            }
        }

    }

}
