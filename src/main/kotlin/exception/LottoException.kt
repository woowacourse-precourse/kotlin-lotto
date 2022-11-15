package exception


class LottoException {

    fun priceException(lottoSize: Int) {
        require(lottoSize % 1000 == 0) {
            throw IllegalArgumentException()
        }
    }

    fun correctException(correct: List<Int>) {
        require(correct.size == 6 && correct.distinct().size == 6
                && correct.all { it in 1..45 }) {
            throw IllegalArgumentException()
        }
    }

    fun bonusException(correct: List<Int>, bonus: Int) {
        require(bonus !in correct && bonus in 1..45) {
            throw IllegalArgumentException()
        }
    }
}