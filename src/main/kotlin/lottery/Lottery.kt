package lottery

import lotto.Lotto
import camp.nextstep.edu.missionutils.Console.readLine
import data.NumberRange
import data.Price

class Lottery {
    val winningCounter: HashMap<String, Int> = hashMapOf()
    lateinit var lotteryNumbers: Lotto
    val quickPicks: MutableList<Lotto> = mutableListOf()
    var bonusNumber: Int = 0
    var purchase: Int = 0
    var income: Int = 0
    var incomeRatio: Float = 0.0f

    fun printTicketNumbers() {
        TODO("구매 개수 출력 함수")
    }

    fun printQuickPick() {
        TODO("랜덤 배열 출력 함수")
    }

    fun printWinnings() {
        TODO("당첨 내역 출력 함수")
    }

    fun getAmount() {
        println("구입 금액을 입력해주세요.")
        try {
            val purchase = readLine().toInt()
            if (purchase % Price.STANDARD.price != 0)
                throw IllegalArgumentException("[ERROR] ${Price.STANDARD.price}원 단위로 입력하세요.")
            this.purchase = purchase
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("[ERROR] 숫자만 입력하세요")
        }

    }

    fun getLotteryNumbers() {
        println("당첨 번호를 입력해 주세요.")
        val lotteryNumbers = readLine().split(",").map { it.toInt() }

        this.lotteryNumbers = Lotto(lotteryNumbers)
    }

    fun getQuickPicks() {
        TODO("랜덤 로또 생성 함수")
    }

    fun getBonusNumber() {
        println("보너스 번호를 입력해 주세요.")
        try {
            val bonusNumber = readLine().toInt()
            if (bonusNumber !in NumberRange.START.number..NumberRange.END.number) {
                throw IllegalArgumentException(
                    "[ERROR] ${NumberRange.START.number}와 ${NumberRange.END.number} 사이 숫자를 입력하세요.")
            }
            this.bonusNumber = bonusNumber
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("[ERROR] 숫자만 입력하세요.")
        }

    }

}
