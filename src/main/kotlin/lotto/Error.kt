package lotto

class Error {
    companion object {
        fun rangeError() {
            println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }

        fun sizeError() {
            println("[ERROR] 숫자 개수는 6개여야 합니다.")
        }

        fun typeError() {
            println("[ERROR] 숫자를 입력해야 합니다.")
        }

        fun overlapError() {
            println("[ERROR] 숫자끼리 겹쳐서는 안됩니다.")
        }

        fun formError() {
            println("[ERROR] 양식에 맞춰서 입력해주셔야 합니다.")
        }
    }
}