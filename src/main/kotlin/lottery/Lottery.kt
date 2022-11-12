package lottery

import lotto.Lotto
import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms
import data.NumberRange
import data.Price
import data.WinningAmount
import kotlin.math.round

class Lottery {
    private val winningCounter: MutableMap<String, Int> = mutableMapOf<String, Int>().withDefault { 0 }
    lateinit var lotteryNumbers: Lotto
    private val quickPicks: MutableList<Lotto> = mutableListOf()
    var bonusNumber: Int = 0
    var purchase: Int = 0
    var income: Double = 0.0
    private var incomeRatio: Double = 0.0

    fun getPurchase() {
        println("구입 금액을 입력해주세요.")

        val input = readLine()
        if (input.toDoubleOrNull() == null)
            throw IllegalArgumentException("[ERROR] 숫자만 입력하세요.")

        val purchase = input.toInt()
        if (purchase % Price.STANDARD.price != 0)
            throw IllegalArgumentException("[ERROR] ${Price.STANDARD.price}원 단위로 입력하세요.")

        this.purchase = purchase
    }

    fun printQuickPick() {
        this.getQuickPicks()
        println("${this.quickPicks.size}개를 구매했습니다.")

        this.quickPicks.forEach {
            println("[${it.getList().joinToString(separator = ", ")}]")
        }
    }

    private fun getQuickPicks() {
        val n = this.purchase / Price.STANDARD.price
        for (i in 0 until n){
            val numbers = Randoms.pickUniqueNumbersInRange(
                NumberRange.START.number, NumberRange.END.number, NumberRange.MAX.number)

            this.quickPicks.add(Lotto(numbers))
        }

    }

    fun getLotteryNumbers() {
        println("당첨 번호를 입력해 주세요.")
        val lotteryNumbers = readLine().split(",").map { it.toInt() }
        this.lotteryNumbers = Lotto(lotteryNumbers)

    }

    fun getBonusNumber() {
        println("보너스 번호를 입력해 주세요.")
        val input = readLine()
        if (input.toDoubleOrNull() == null)
            throw IllegalArgumentException("[ERROR] 숫자만 입력하세요.")

        val bonusNumber = input.toInt()
        if (bonusNumber !in NumberRange.START.number..NumberRange.END.number) {
            throw IllegalArgumentException(
                "[ERROR] ${NumberRange.START.number}와 ${NumberRange.END.number} 사이 숫자를 입력하세요.")
        }

    }

    fun printWinnings() {
        this.getWinnings()

        println("3개 일치 (5,000원) - ${this.winningCounter.getValue("3")}개")
        println("4개 일치 (50,000원) - ${this.winningCounter.getValue("4")}개")
        println("5개 일치 (1,500,000원) - ${this.winningCounter.getValue("5_0")}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${this.winningCounter.getValue("5_1")}개")
        println("6개 일치 (2,000,000,000원) - ${this.winningCounter.getValue("6")}개")

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
        this.getIncomeRatio()
        this.incomeRatio = round(this.income / this.purchase * 1000) / 10
        println("총 수익률은 ${this.incomeRatio}%입니다.")
    }

    private fun getIncomeRatio() {
        this.winningCounter.forEach { (k, v) ->
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
