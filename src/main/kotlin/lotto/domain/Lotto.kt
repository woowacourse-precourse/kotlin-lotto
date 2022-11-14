package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun checkMyLotto(winNumbers: List<Int>, bonusNumber: Int, numbers: List<Int> = this.numbers): Win {
        var matchedBall = 0
        var isMatchedBonusBall = false

        for (number in numbers) {
            if (winNumbers.contains(number)) {
                matchedBall++
            }
        }
        if (numbers.contains(bonusNumber)) {
            isMatchedBonusBall = true
        }
        return Win.getMyPlace(matchedBall, isMatchedBonusBall)
    }
}
