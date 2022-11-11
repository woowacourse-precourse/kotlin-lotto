package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun lottoException() {
        val sortLotto = numbers.sorted()
        var previousNumber = sortLotto[0]

        for(num in 1 until sortLotto.size) {
            if(previousNumber == sortLotto[num]) {
                throw IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.")
            }

            if(sortLotto[num] !in 1 .. 45) {
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }

            previousNumber = sortLotto[num]
        }
    }

    fun bonusNumberException(bonusNumber: Int) {
        if(bonusNumber !in 1 .. 45) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }

        if(numbers.contains(bonusNumber)) {
            throw IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.")
        }
    }
}
