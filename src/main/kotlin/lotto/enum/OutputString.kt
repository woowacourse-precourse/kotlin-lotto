package lotto.enum

enum class OutputString(val string: String) {
    PURCHASE_NUMBER("개를 구매했습니다.") {
        override fun print(number: Int) = println("$number$string")
    };

    abstract fun print(number: Int)
}