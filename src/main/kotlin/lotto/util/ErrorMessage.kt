package lotto.util

class ErrorMessage {
    companion object {
        private const val ERROR = "[ERROR] "
        fun integer(kind: String) = println(ERROR + kind + "숫자여야 합니다.")

        fun size(kind: String) = println(ERROR + kind + "6개가 필요합니다.")

        fun range(kind: String) = println(ERROR + kind + "1~45 사이의 숫자여야 합니다.")

        fun duplicate(kind: String) = println(ERROR + kind + "중복되지 않은 수여야 합니다.")

        fun unit(kind: String) = println(ERROR + kind + "1000원 단위여야 합니다.")
    }
}