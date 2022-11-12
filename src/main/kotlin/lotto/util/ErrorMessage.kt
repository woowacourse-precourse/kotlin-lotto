package lotto.util

class ErrorMessage {
    companion object {
        private const val ERROR = "[ERROR] "
        fun intError(kind: String) = println(ERROR + kind + "숫자여야 합니다.")

        fun sizeError(kind: String) = println(ERROR + kind + "6개가 필요합니다.")

        fun rangeError(kind: String) = println(ERROR + kind + "1~45 사이의 숫자여야 합니다.")

        fun duplicateError(kind: String) = println(ERROR + kind + "중복되지 않은 수여야 합니다.")

        fun unitError(kind: String) = println(ERROR + kind + "1000원 단위여야 합니다.")
    }
}