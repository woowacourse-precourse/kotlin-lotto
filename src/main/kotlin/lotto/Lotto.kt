package lotto

class Lotto(private val numbers: List<Int>) {

    enum class Sizes(val size: Int) {
        LOTTO_NUMBER_SIZE(6),
        LOTTO_RANGE_END(45),
        LOTTO_RANGE_START(1);
    }

    init {
        require(numbers.size == Sizes.valueOf("LOTTO_NUMBER_SIZE").size) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 총 6개여야 합니다.")
        }
        require(checkLottoRange(numbers) == true) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
        require(checkLottoDuplicated(numbers) == true) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 서로 중복되는 숫자가 아니어야 합니다.")
        }
    }

    // TODO: 추가 기능 구현

    fun checkLottoRange(numbers: List<Int>): Boolean {
        numbers.forEach {
            if (Sizes.valueOf("LOTTO_RANGE_START").size <= it && it <= Sizes.valueOf("LOTTO_RANGE_END").size)
                return true
        }
        return false
    }

    fun checkLottoDuplicated(numbers: List<Int>): Boolean {
        val duplicatedEle = numbers.groupingBy { it }.eachCount().filter { it.value > 1 }
        if (duplicatedEle.isNotEmpty()) {
            return false
        }
        return true
    }


}
