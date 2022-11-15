package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

enum class WinningNumbers(val order: Int) {
    FIRST(6),
    SECOND(7),
    THIRD(5),
    FOURTH(4),
    FIFTH(3);
}

data class __Lotto__(val repeats: Int) {
    private var idx: MutableList<MutableList<Int>> = mutableListOf()
    private var correctCount: MutableList<Int> = MutableList(8) { 0 }

    init {
        repeat(repeats) {
            idx += setLottoNum().toMutableList()
            Lotto(idx.last().toList())
        }
    }

    private fun setLottoNum(): List<Int> {
        var lottoNum = mutableSetOf<Int>()
        while (lottoNum.size < 6) lottoNum += Randoms.pickNumberInRange(1, 45)
        return lottoNum.toList().sorted()
    }

    public fun printBuyLotto() {
        println("${idx.size}개를 구매했습니다.")
        idx.forEach { Lotto(it).printLotto() }
        println("")
    }

    public fun calculateCorrectCount(winningNumbers: List<Int>, bonus: Int): MutableList<Int> {
        idx.forEach { correctCount[Lotto(it).calculateCorrectCount(winningNumbers, bonus)] += 1 }
        return correctCount
    }

    public fun calculateProfit(): Double {
        var profit = 0.0
        correctCount.forEachIndexed { index, count ->
            profit += when (index) {
                WinningNumbers.FIFTH.order  -> count * 5_000
                WinningNumbers.FOURTH.order -> count * 50_000
                WinningNumbers.THIRD.order  -> count * 1_500_000
                WinningNumbers.SECOND.order -> count * 30_000_000
                WinningNumbers.FIRST.order  -> count * 2_000_000_000
                else -> 0
            }
        }
        return kotlin.math.round(profit / (idx.size * 1000) * 1000) / 10000 * 100
    }
    public fun printResult() {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5,000원)- ${correctCount[WinningNumbers.FIFTH.order]}개")
        println("4개 일치 (50,000원)- ${correctCount[WinningNumbers.FOURTH.order]}개")
        println("5개 일치 (1,500,000원)- ${correctCount[WinningNumbers.THIRD.order]}개")
        println("5개 일치, 보너스 볼 일치(30,000,000원)- ${correctCount[WinningNumbers.SECOND.order]}개")
        println("6개 일치 (2,000,000,000원)- ${correctCount[WinningNumbers.FIRST.order]}개")
        println("총 수익률은 " + String.format("%.2f", calculateProfit()) + "%입니다.")
    }
}

class Lotto(private val numbers: List<Int?>) {
    init {
        require(0 !in numbers) { "[ERROR] : 양식을 지켜주세요. ex 1,2,3,4,5" }
        require(numbers.size == 6) { "[ERROR] : 길이가 6이 아닙니다" }
        require(numbers.distinct().size == numbers.size) { "[ERROR] : 중복된 숫자가 있습니다" }
        require(numbers.all { it in 1..45 }) { "[ERROR] : 1~45 사이의 숫자가 아닙니다" }
    }

    public fun printLotto() = println(numbers)

    public fun calculateCorrectCount(winningNumbers: List<Int>, bonus: Int): Int {
        var correctCount = 0
        numbers.forEach { if (it in winningNumbers) correctCount++ }
        if (correctCount == 5 && bonus in numbers) correctCount = 7
        return correctCount
    }
}

class Service() {
    public fun buyLotto(): Int {
        println("구입금액을 입력해 주세요.")
        val pay = Console.readLine()?.toIntOrNull() ?: 0
        require(pay >= 1000) { "[ERROR] : 1000원 이상의 금액을 입력해주세요" }
        require(pay != 0) { "[ERROR] : 0보다 큰 숫자를 입력해주세요" }
        require(pay % 1000 == 0) { "[ERROR] : 1000원 단위로 입력해주세요" }
        println("")
        return pay / 1000
    }

    public fun winningNumbers(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val winningNumbers = Console.readLine()?.split(",")?.map { it.toIntOrNull() ?: 0 } ?: listOf(0)
        Lotto(winningNumbers)
        println("")
        return winningNumbers
    }

    public fun bonus(): Int {
        println("보너스 번호를 입력해 주세요.")
        val bonus = Console.readLine()?.toIntOrNull() ?: 0
        require(bonus in 1..45) { "[ERROR] : 1~45 사이의 숫자가 아닙니다" }
        println("")
        return bonus
    }
}
