package lotto

import java.util.*

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getMatchingNumber(lottoNumber: List<List<Int>>) {
        for (randLotto in lottoNumber) {
            var matchingNumber = LOTTO_SIZE - (numbers.minus(randLotto)).size
            println("${randLotto}와 ${numbers} 비교: ${matchingNumber}개 일치")
        }

    }
}
