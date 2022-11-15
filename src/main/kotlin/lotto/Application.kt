package lotto

import camp.nextstep.edu.missionutils.Randoms

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
    },
    BONUS_NUMBER {
        override fun print() {
            super.print()
            println("올바르지 않은 보너스 번호입니다.")
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
    private var inputAmount = 0
    private var lotteries = 0
    private val winningNumbers = ArrayList<Int>()
    private var bonusNumber = 0
    private val buyLotteries = ArrayList<Lotto>()
    private var counts = arrayOf(0, 0, 0, 0)
    private var bonusCounts = 0

    fun simulate() {
        getPurchaseAmount()
        printLotteriesNumber()

        getBuyLotteries()
        printBuyLotteries()

        getWinningNumbers()
        getBonusNumber()

        getResult()
        printResult()
        printRatio()
    }

    private fun getPurchaseAmount() {
        val inputAmount = getPurchaseAmountInput()
        checkInputAmountValid(inputAmount)
        this.inputAmount = inputAmount
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
        checkInputBonusNumberValid(inputBonusNumber)
        initBonusNumber(inputBonusNumber.toInt())
    }

    private fun getBonusNumberInput(): String {
        println("보너스 번호를 입력해 주세요.")
        return readLine() ?: ""
    }

    private fun checkInputBonusNumberValid(bonusNumber: String) {
        try {
            bonusNumber.toInt()
        } catch (e: Exception) {
            ErrorType.BONUS_NUMBER.print()
            throw IllegalArgumentException()
        }

        val number = bonusNumber.toInt()

        if(number < 1 || number > 45)  {
            ErrorType.BONUS_NUMBER.print()
            throw IllegalArgumentException()
        }
    }

    private fun initBonusNumber(number: Int) {
        bonusNumber = number
    }

    private fun printLotteriesNumber() {
        println("${lotteries}개를 구매했습니다.")
    }

    private fun getLotteriesNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    private fun getBuyLotteries() {
        for(i in 0 until lotteries) {
            buyLotteries.add(Lotto(getLotteriesNumber()))
        }
    }

    private fun printBuyLotteries() {
        for(i in 0 until lotteries) {
            buyLotteries[i].printNumbers()
        }
    }

    private fun getResult() {
        for(lotto in buyLotteries) {
            val result = lotto.checkRank(winningNumbers)
            val isBonus = lotto.isContainNumber(bonusNumber, winningNumbers)
            counts[result - 3]++
        }
    }

    private fun checkBonus(isBonus: Boolean, count: Int) {
        if(isBonus) {
            bonusCounts++
        } else {
            counts[count - 3]++
        }
    }

    private fun printResult() {
        println("3개 일치 (5,000원) - ${counts[0]}개")
        println("4개 일치 (50,000원) - ${counts[1]}개")
        println("5개 일치 (1,500,000원) - ${counts[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${bonusCounts}개")
        println("6개 일치 (2,000,000,000원) - ${counts[3]}개")
    }

    private fun printRatio() {
        var sum = 0L
        sum += 5000 * counts[0]
        sum += 50000 * counts[1]
        sum  += 1500000 * counts[2]
        sum += 30000000 * bonusCounts
        sum += 2000000000 * counts[3]
        println("총 수익률은 ${sum / inputAmount.toDouble()}%입니다.")
    }
}