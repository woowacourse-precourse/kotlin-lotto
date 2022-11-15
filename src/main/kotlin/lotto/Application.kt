package lotto

enum class ErrorType {
    AMOUNT {
        override fun print() {
            super.print()
            println("입력은 1,000의 배수여야 합니다.")
        }
    },
    WINNING_NUMBER {
        override fun print() {
            super.print()
            println("올바르지 않은 당첨 번호입니다.")
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
    private var bonusNumber = 0

    fun simulate() {
        getPurchaseAmount()
        getWinningNumbers()
        getBonusNumber()
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
        val parsedNumbers = parseInputNumbers(inputNumbers)
        initWinningNumbers(parsedNumbers)
    }

    private fun getInputWinningNumbers(): String {
        println("당첨 번호를 입력해 주세요.")
        return readLine() ?: ""
    }

    private fun parseInputNumbers(numbers: String): ArrayList<Int> {
        val splitNumbers = numbers.split(",")
        val resultNumbers = ArrayList<Int>()

        for(number in splitNumbers) {
            checkWinningNumbersValid(number)
            resultNumbers.add(number.toInt())
        }

        checkWinningNumbersValue(resultNumbers)
        checkWinningNumbersLength(resultNumbers)

        return resultNumbers
    }

    private fun checkWinningNumbersValid(number: String) {
        for(character in number) {
            checkWinningNumberValid(character)
        }
    }

    private fun checkWinningNumberValid(character: Char) {
        if(!character.isDigit()) {
            ErrorType.WINNING_NUMBER.print()
            throw IllegalArgumentException()
        }
    }

    private fun checkWinningNumbersValue(numbers: ArrayList<Int>) {
        for(number in numbers) {
            checkWinningNumberRange(number)
        }
    }

    private fun checkWinningNumberRange(number: Int) {
        if(number < 1 || number > 45) {
            ErrorType.WINNING_NUMBER.print()
            throw IllegalArgumentException()
        }
    }

    private fun checkWinningNumbersLength(numbers: ArrayList<Int>) {
        if(numbers.size != 6) {
            ErrorType.WINNING_NUMBER.print()
            throw IllegalArgumentException()
        }
    }

    private fun initWinningNumbers(numbers: ArrayList<Int>) {
        winningNumbers.addAll(numbers)
    }

    private fun getBonusNumber() {
        val inputBonusNumber = getBonusNumberInput()

    }

    private fun getBonusNumberInput(): String {
        println("보너스 번호를 입력해 주세요.")
        return readLine() ?: ""
    }
}