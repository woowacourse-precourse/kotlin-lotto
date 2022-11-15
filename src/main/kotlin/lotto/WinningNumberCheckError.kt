package lotto

class WinningNumberCheckError(private val userInput: String) {
    fun throwWinningNumberFormException() {
        userInput.forEach { char ->
            if (!(char in '0'..'9' || char == ',')) {
                println("[ERROR] 로또 번호는 숫자와 ,만 입력 해야 합니다.")
                throw IllegalArgumentException()
            }
        }
    }
}
