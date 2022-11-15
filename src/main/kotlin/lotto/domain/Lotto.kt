package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun throwLottoException() {
        if (numbers.size != 6) throw IllegalArgumentException("[ERROR] 6개의 숫자만 입력 가능합니다")
        if (numbers.distinct().size != 6) throw IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다")
    }

}
