package lotto.message

object Output {
    fun purchaseAmount() {
        println("구입금액을 입력해 주세요.")
    }

    fun resultPurchase(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun winningNumber() {
        println("당첨 번호를 입력해 주세요.")
    }

    fun bonusNumber() {
        println("보너스 번호를 입력해 주세요.")
    }

    fun winningStatistics() {
        println("당첨 통계\n---")
    }

    fun resultYield(number: Double) {
        println("총 수익률은 ${number}%입니다.")
    }

    fun resultFifth(number: Int) {
        println("3개 일치 (5,000원) - ${number}개")
    }

    fun resultFourth(number: Int) {
        println("4개 일치 (50,000원) - ${number}개")
    }

    fun resultThird(number: Int) {
        println("5개 일치 (1,500,000원) - ${number}개")
    }

    fun resultSecond(number: Int) {
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${number}개")
    }

    fun resultFirst(number: Int) {
        println("6개 일치 (2,000,000,000원) - ${number}개")
    }
}