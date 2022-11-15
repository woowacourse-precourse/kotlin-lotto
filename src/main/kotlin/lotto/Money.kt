package lotto

class Money(private val money: String) {
    init {
        require(stringCheck(money)) {
            print("[ERROR] : 숫자 형태로 입력해 주세요.")
            throw NoSuchElementException()
        }
        require(money.toInt() % 1000 == 0) {
            "[ERROR] : 1000원 단위로 입력해 주세요."
        }
    }

    fun stringCheck(str: String): Boolean {
        var element: Char
        var flag = true

        for (i in str.indices) {
            element = str.elementAt(i)
            if (element.code < 48 || element.code > 57) {
                flag = false
            }
        }
        return flag
    }

    fun run(): Int {
        var lottoCount = money.toInt() / 1000
        return lottoCount
    }
}