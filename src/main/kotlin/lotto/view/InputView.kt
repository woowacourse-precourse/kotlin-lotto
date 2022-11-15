package lotto.view

object InputView {
    fun inputMoneyForLotto(): Int {
        println("구입금액을 입력해주세요.")
        return readln().toInt().checkMoney()
    }

    fun inputWinningNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        return readln().split(",").checkWinningNumber().map { it.toInt() }
    }

    fun inputBonusNumber(winningNumber : List<Int>) : Int {
        println("보너스 번호를 입력해 주세요.")
        return readln().toInt().checkBonusNumber(winningNumber)
    }
}

private fun Int.checkMoney(): Int {
    require(this % LOTTO_PRICE == IS_1000_UNIT) { "[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다." }
    return this
}

private fun List<String>.checkWinningNumber(): List<String> {
    require(this.size == LOTTO_SIZE && this.distinct().size == LOTTO_SIZE) { "[ERROR] 당첨 번호는 중복되지 않는 숫자 6개 이어야 합니다. " }
    return this
}

private fun Int.checkBonusNumber(winningNumber: List<Int>): Int {
    require(!winningNumber.contains(this)) { "[ERROR] 보너스 번호는 당첨번호와 중복되지 않아야 합니다."}
    return this
}

private const val LOTTO_PRICE = 1000
private const val LOTTO_SIZE = 6
private const val IS_1000_UNIT = 0