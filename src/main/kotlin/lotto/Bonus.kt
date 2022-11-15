package lotto

class Bonus(private val number: String, private val list: List<Int>) {
    init {
        println(number.toInt())
        require(stringCheck(number)) {
            print("[ERROR] : 숫자 형태로 입력해 주세요.")
            throw NoSuchElementException()
        }
        require(number.toInt() <= 45 && number.toInt() >= 1) {
            "[ERROR] : 올바른 범위의 숫자를 입력해 주세요.(1~45)."
        }
        require(!(list.contains(number.toInt()))) {
            "[ERROR] : 입력한 당첨 번호와 중복됩니다."
        }
    }

    fun run(): Int {
        return number.toInt()
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
}