package lotto

class Printer {
    fun printAmountMessage() {
        println("구입금액을 입력해 주세요.")
    }

    fun printLottoCountMessage(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    companion object {
        fun printError(errorMessage: String) {
            println("[ERROR] $errorMessage")
        }
    }
}