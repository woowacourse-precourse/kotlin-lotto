package lotto

private const val UNIT_NOT_THOUSAND = "[ERROR] 구입금액은 1000원 단위여야합니다."
private const val MONEY_NOT_NATURAL_NUMBER = "[ERROR] 구입금액은 자연수여야합니다."
private const val PURCHASE_STANDARD_UNIT = 1000
private const val THOUSAND_UNIT = "000"

class Cacher {
    private val ticketingMachine = TicketingMachine()

    fun returnCreatedLotteries(number: Int): List<Lotto> {
        return ticketingMachine.createLottoNumbers(number)
    }

    fun calculateNumberOfLotteries(money: Int): Int {
        return money / PURCHASE_STANDARD_UNIT
    }

    fun receiveMoney(inputMoney: String): Int {
        isNumber(inputMoney)
        isThousandUnit(inputMoney)
        return inputMoney.toInt()
    }

    private fun isNumber(inputMoney: String) {
        if (!inputMoney.all { Character.isDigit(it) }) {
            throw IllegalArgumentException(MONEY_NOT_NATURAL_NUMBER)
        }
    }

    private fun isThousandUnit(inputMoney: String) {
        if (inputMoney.takeLast(3) != THOUSAND_UNIT) {
            throw IllegalArgumentException(UNIT_NOT_THOUSAND)
        }
    }
}
