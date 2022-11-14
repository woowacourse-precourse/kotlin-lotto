package lotto

class Purchase(price: String?) {
    val price: Int
    val count: Int

    init {
        exceptionTest(price)
        this.price = price!!.toInt()
        this.count = this.price / 1000
    }

    private fun exceptionTest(price: String?) {
        require(!price.isNullOrEmpty()) {
            println(ERROR_NO_INPUT)
        }
        val regex = "[0-9]+".toRegex()
        require(price.matches(regex)) {
            println(ERROR_NOT_INT)
        }
        require(price.toInt() % 1000 == 0) {
            println(ERROR_1000UNIT)
        }
    }

    companion object {
        const val ERROR_NO_INPUT = "[ERROR] 구입 금액을 입력하지 않았습니다."
        const val ERROR_NOT_INT = "[ERROR] 구입 금액에는 숫자만 입력해야합니다."
        const val ERROR_1000UNIT = "[ERROR] 구입 금액이 1,000원 단위여야 합니다."

        fun inputPrice(): String? {
            println("구입금액을 입력해 주세요.")
            return readLine()
        }
    }
}