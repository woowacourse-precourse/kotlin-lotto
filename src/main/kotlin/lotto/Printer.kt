package lotto

class Printer {
    fun printAmountMessage() {
        println("구입금액을 입력해 주세요.")
    }

    fun printLottoCountMessage(count: Int) {
        println("\n${count}개를 구매했습니다.")
    }

    fun printBoughtLottoList(lotteries: List<List<Int>>) {
        lotteries.forEach { list ->
            println(list)
        }
    }

    fun printWinningNumberMessage() {
        println("\n당첨 번호를 입력해 주세요.")
    }

    fun printBonusNumberMessage() {
        println("\n보너스 번호를 입력해 주세요.")
    }

    companion object {
        fun printError(errorMessage: String) {
            println("[ERROR] $errorMessage")
        }
    }
}