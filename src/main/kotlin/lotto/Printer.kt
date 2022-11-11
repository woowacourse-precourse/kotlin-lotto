package lotto

class Printer {
    fun printAmountMessage() {
        println("구입금액을 입력해 주세요.")
    }

    companion object {
        fun printError(errorMessage: String) {
            println("[ERROR] $errorMessage")
        }
    }
}