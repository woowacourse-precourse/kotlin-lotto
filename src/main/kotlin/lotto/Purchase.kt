package lotto

class Purchase {
    fun checkMoney(money: Int) {
        if (money % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 잘못된 값을 입력했습니다.")
        }
    }

    fun updateLottoCount(money: Int): Int {
        return money / 1000
    }

}
