package lottery

import lotto.Lotto

class Lottery {
    val winningCounter: HashMap<String, Int> = hashMapOf()
    val lotteryNumbers: MutableList<Int> = mutableListOf()
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
        TODO("로또 구입 금액 입력 함수")
    }

    fun getLotteryNumbers() {
        TODO("당첨 번호 입력 함수")
    }

    fun getQuickPicks() {
        TODO("랜덤 로또 생성 함수")
    }

    fun getBonusNumber() {
        TODO("보너스 번호 입력 함수")
    }
}
