package lotto

class Customer {

    fun payMoney(): Int {
        return readLine()!!.toInt()
    }

    fun getLotto() {
        Seller().setLotto()
    }

    fun checkLotto() {

    }
}