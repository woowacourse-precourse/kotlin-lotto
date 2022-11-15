package lotto

class LottoCheckError(private val numbers: List<Int>) {
    fun checkLottoThrowException() {
        throwLottoSizeException()
        throwLottoNumberRangeException()
        throwLottoNumberDuplicationException()
    }

    private fun throwLottoSizeException() {
        if (numbers.size != 6) {
            println("[ERROR] 로또 번호는 6개의 숫자여야 합니다.")
            throw IllegalArgumentException()
        }
    }

    private fun throwLottoNumberRangeException() {
        for (number in numbers) {
            if (number !in 1..45) {
                println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
                throw IllegalArgumentException()
            }
        }
    }

    private fun throwLottoNumberDuplicationException() {
        val distinctNumbers = numbers.distinct()
        if(numbers.size != distinctNumbers.size) {
            println("[ERROR] 로또 번호는 중복이 불가능 합니다.")
            throw IllegalArgumentException()
        }
    }
}
