package machine

class Machine(val inputMoney: Int) {
    init {
        require(inputMoney % 1000 == 0) { NOT_THOUSANDS_NUMBER }
    }

    companion object {
        const val NOT_THOUSANDS_NUMBER = "[ERROR] 입력된 금액이 1000원단위여야 합니다."
    }
}