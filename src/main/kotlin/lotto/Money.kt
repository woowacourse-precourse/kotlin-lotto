package lotto

class Money{
    fun InputMoney(): String? {
        println("구입금액을 입력해 주세요.")
        val input_buy = readLine()
        return input_buy
    }
}