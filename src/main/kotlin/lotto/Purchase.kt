package lotto

class Purchase {

    fun createExpense(): Int {
        println("구입금액을 입력해 주세요.")
        val expense = readLine()!!.toInt()
        checkMoney(expense)
        return expense
    }

    fun checkMoney(money: Int) {
        val haveWrongMoney = (money % LOTTERY_PRICE != 0)
        if (haveWrongMoney) {
            throw IllegalArgumentException("[ERROR] 잘못된 값을 입력했습니다.")
        }
    }

    fun updateLottoQuantity(money: Int): Int {
        return money / LOTTERY_PRICE
    }

}

const val LOTTERY_PRICE = 1000