package lotto

enum class ErrorType {
    AMOUNT {
        override fun print() {
            super.print()
            println("입력은 1,000의 배수여야 합니다.")
        }
    };

    open fun print() {
        print("[ERROR] ")
    }
}

fun main() {
    val lottoGame = LottoGame()
    lottoGame.simulate()
}

class LottoGame {
    private var lotteries = 0
    private val winningNumbers = ArrayList<Int>()

    fun simulate() {
        getPurchaseAmount()
        getWinningNumbers()
    }

    private fun getPurchaseAmount() {
        val inputAmount = getPurchaseAmountInput()
        checkInputAmountValid(inputAmount)
        initLotteries(inputAmount)
    }

    private fun getPurchaseAmountInput(): Int {
        print("구입금액을 입력해 주세요.\n")
        return readLine()?.toInt() ?: 0
    }

    private fun checkInputAmountValid(amount: Int) {
        if(amount == 0 || amount % 1000 != 0) {
            ErrorType.AMOUNT.print()
            throw IllegalArgumentException()
        }
    }

    private fun initLotteries(amount: Int) {
        lotteries = amount / 1000
    }

    private fun getWinningNumbers() {
        val inputNumbers = getInputWinningNumbers()

    }

    private fun getInputWinningNumbers(): String {
        println("당첨 번호를 입력해 주세요.")
        return readLine() ?: ""
    }

    private fun parseInputNumbers(numbers: String): ArrayList<Int> {
        val splitNumbers = numbers.split(",")
        val resultNumbers = ArrayList<Int>()

        for(number in splitNumbers) {
            checkWinningNumberValid(number)
            resultNumbers.add(number.toInt())
        }

        return resultNumbers
    }

    private fun checkWinningNumberValid(number: String) {

    }
}