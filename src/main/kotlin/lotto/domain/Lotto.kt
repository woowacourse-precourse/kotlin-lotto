package lotto.domain

import lotto.Reward

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { LOTTO_SIZE_EXCEPTION }
        require(numbers.distinct().size == LOTTO_SIZE) { LOTTO_DUPLICATE_EXCEPTION }
        require(numbers.all { it in LOTTO_RANGE_START..LOTTO_RANGE_END }) { LOTTO_RANGE_EXCEPTION }
    }

    fun sort(): Lotto {
        return Lotto(numbers.sorted())
    }

    fun toStr(): String {
        return numbers.joinToString(", ")
    }

    fun check(winning: WinningNumber): String {
        var cnt = 0
        var bonus = false
        for (num in numbers) {
            if (num in winning.numbers()) {
                cnt += 1
            }
            if (num == winning.bonus()) {
                bonus = true
            }
        }

        return Reward.getRank(cnt, bonus)
    }

    companion object {
        const val LOTTO_SIZE = 6
        const val LOTTO_RANGE_START = 1
        const val LOTTO_RANGE_END = 45
        const val LOTTO_SIZE_EXCEPTION = "[ERROR] 로또 번호의 갯수는 6개 입니다."
        const val LOTTO_DUPLICATE_EXCEPTION = "[ERROR] 로또 번호는 중복이 있으면 안됩니다."
        const val LOTTO_RANGE_EXCEPTION = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    }
}
