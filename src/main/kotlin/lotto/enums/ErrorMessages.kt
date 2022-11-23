package lotto.enums

enum class ErrorMessages(private val messages: String) {
    PREFIX("[ERROR]"),
    DIGIT_EXCEPTION("숫자가 아닙니다."),
    REMAINDER_EXCEPTION("나머지가 존재합니다."),
    SIZE_EXCEPTION("갯수가 맞지 않습니다."),
    RANGE_EXCEPTION("범위를 벗어났습니다."),
    DISTINCT_EXCEPTION("중복이 있습니다.");

    override fun toString(): String = "${PREFIX.messages} $messages"
}