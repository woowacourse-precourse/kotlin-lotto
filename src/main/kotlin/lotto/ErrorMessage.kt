package lotto

class ErrorMessage {
    companion object {
        private const val ERROR = "[ERROR] "
        fun intError(kind: String) = ERROR + kind + "숫자여야 합니다."

        fun sizeError(kind: String) = ERROR + kind + "6개가 필요합니다."

        fun rangeError(kind: String) = ERROR + kind + "1~45 사이의 숫자여야 합니다."

        fun duplicateError(kind: String) = ERROR + kind + "중복되지 않은 수여야 합니다."

        fun unitError(kind: String) = ERROR + kind + "1000원 단위여야 합니다."

        fun systemError() = ERROR + "시스템을 종료합니다."
    }
}