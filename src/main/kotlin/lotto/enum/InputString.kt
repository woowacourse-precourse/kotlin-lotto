package lotto.enum

enum class InputString(val string: String) {
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요.") {
        override fun print() = println(string)
    },
    ASK_WINNING_NUMBER("당첨 번호를 입력해 주세요.") {
        override fun print() = println(string)
    },
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요.") {
        override fun print() = println(string)
    };

    abstract fun print()
}