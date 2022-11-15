package lotto.domain

import lotto.utils.*

class Lotto(private val winningNumber: List<Int>) {
    init {
        // 당첨 번호가 6개가 아닌 경우
        require(winningNumber.size == LOTTO_NUM_LIMIT) {
            throw IllegalArgumentException(SIZE_BOUNDS_ERROR_MSG)
        }

        // 중복된 수를 입력한 경우
        require(winningNumber.toSet().size == winningNumber.size) {
            throw IllegalArgumentException(WINNING_DUPLICATE_ERROR_MSG)
        }

        // 1~45까지의 범위를 벗어난 경우
        for (item in winningNumber) {
            require(item in MIN_VALUE..MAX_VALUE) {
                throw IllegalArgumentException(RANGE_BOUNDS_ERROR_MSG)
            }
        }
    }

    // 로또 번호에 당첨 번호가 몇개 포함되어 있는지 검사한다.
    // 5개가 일치하는 경우, 보너스 번호도 검사한다.
    fun getWinnerList(lottoNumbers: List<List<Int>>, bonusNumber: Int): List<Int> {
        val winners = mutableListOf(0, 0, 0, 0, 0)
        val judgement = Judgement()
        for (lottoNumber in lottoNumbers) {
            when (judgement.countMatchNumber(lottoNumber, winningNumber)) {
                Ranking.FIRST.count -> winners[Ranking.FIRST.ordinal]++
                Ranking.SECOND.count -> {
                    if (judgement.checkBonusBall(lottoNumber, bonusNumber))
                        winners[Ranking.SECOND.ordinal]++
                    else winners[Ranking.THIRD.ordinal]++
                }
                Ranking.FOURTH.count -> winners[Ranking.FOURTH.ordinal]++
                Ranking.FIFTH.count -> winners[Ranking.FIFTH.ordinal]++
            }
        }
        return winners
    }
}