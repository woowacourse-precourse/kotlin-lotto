package lotto

class Judgment {

    fun checkPurchaseAmount(input: String): Int {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException("[ERROR] 구매 금액을 숫자 형태로 입력해야 합니다.")
        }
        if (input.toInt() % LOTTO_PRICE != 0) {
            throw IllegalArgumentException("[ERROR] 구매 금액을 1000원 단위로 입력하세요.")
        }
        return getPurchaseNumber(input)
    }

    fun getPurchaseNumber(input: String): Int {
        var money = input.toInt()
        return money / LOTTO_PRICE
    }

    fun checkWinningNumber(lottoNumber: MutableList<Int>): Boolean {
        var winningNumber = lottoNumber.distinct().filter { it in 1..45 }
        if (winningNumber.size != LOTTO_SIZE) {
            throw IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.")
        }
        return true
    }

    fun checkBonusNumber(bonusNumber: String, winningNumber: MutableList<Int>) {
        if (bonusNumber.toIntOrNull() == null) {
            throw IllegalArgumentException("[ERROR] 숫자 형태로 입력해주세요.")
        } else if (bonusNumber.toInt() !in 1..45) {
            throw IllegalArgumentException("[ERROR] 1~45 범위 내 숫자를 입력해주세요.")
        } else if (bonusNumber.toInt() in winningNumber){
            throw IllegalArgumentException("[ERROR] 당첨 번호에 이미 존재하는 숫자입니다.")
        }
    }
}