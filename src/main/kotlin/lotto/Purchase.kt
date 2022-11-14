package lotto

class Purchase {
    private var expense = NO_MONEY

    fun createExpense(): Int {
        println("구입금액을 입력해 주세요.")
        expense = readLine()!!.toInt()
        checkMoney(expense)
        println("\n${updateLottoQuantity(expense)}개를 구매했습니다.")
        return updateLottoQuantity(expense)
    }

    fun checkMoney(money: Int) {
        expense = money
        val haveWrongMoney = (expense % LOTTERY_PRICE != 0)
        if (haveWrongMoney) {
            throw IllegalArgumentException("[ERROR] 잘못된 값을 입력했습니다.")
        }
    }

    fun updateLottoQuantity(money: Int): Int {
        expense = money
        return expense / LOTTERY_PRICE
    }

}


const val NO_MONEY = 0
const val LOTTERY_PRICE = 1000