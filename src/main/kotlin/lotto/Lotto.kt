package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        lottoException()
    }

    private fun lottoException() {
        if(numbers.size != 6) {
            println("[ERROR] 입력 갯수가 잘못되었습니다.")
            throw IllegalArgumentException("[ERROR] 입력 갯수가 잘못되었습니다.")
        }

        val isDuplication = numbers.size == numbers.toSet().size
        if(!isDuplication) {
            println("[ERROR] 중복되는 숫자가 있습니다.")
            throw IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.")
        }

        numbers.forEach { num ->
            if(num !in 1..45) {
                println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        }
    }

    fun bonusNumberException(bonusNumber: Int) {
        if(bonusNumber !in 1 .. 45) {
            println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }

        if(numbers.contains(bonusNumber)) {
            println("[ERROR] 중복되는 숫자가 있습니다.")
            throw IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.")
        }
    }
}
