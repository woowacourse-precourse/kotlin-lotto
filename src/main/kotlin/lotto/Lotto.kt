package lotto

import lotto.domain.*
import lotto.utils.*

/**
 * 클래스는 프로퍼티, init 블록, 부 생성자, 메서드, 동반 객체 순으로
 */
class Lotto(private val winningNumber: List<Int>) {
    init {
        // 당첨 번호가 6개가 아닌 경우
        require(winningNumber.size == LOTTO_NUM_LIMIT) {
            handleException(SIZE_BOUNDS_ERROR_MSG)
        }

        // 1~45까지의 범위를 벗어난 경우
        for(item in winningNumber){
            require(item in MIN_VALUE..MAX_VALUE){
                handleException(RANGE_BOUNDS_ERROR_MSG)
            }
        }

        // 중복된 수를 입력한 경우
        val temp = winningNumber.toSet()
        require(temp.size == winningNumber.size){
            handleException(DUPLICATE_ERROR_MSG)
        }
    }

    // 당첨 번호 vs 로또 번호
    // 5개 일치하는 경우, 보너스 번호 vs 로또 번호
    fun getWinnerList(lottoNumbers: List<List<Int>>, bonusNumber: Int): List<Int> {
        val winners = mutableListOf(0, 0, 0, 0, 0)
        val judgement = Judgement()
        for(lottoNumber in lottoNumbers){
            when(judgement.countMatchNumber(lottoNumber, winningNumber)){
                FIRST_WINNER_NUM -> winners[FIRST_WINNER_INDEX]++
                SECOND_THIRD_WINNER_NUM ->  {
                    if(judgement.checkBonusBall(lottoNumber, bonusNumber)) winners[SECOND_WINNER_INDEX]++
                    else winners[THIRD_WINNER_INDEX]++
                }
                FORTH_WINNER_NUM -> winners[FORTH_WINNER_INDEX]++
                FIFTH_WINNER_NUM -> winners[FIFTH_WINNER_INDEX]++
            }
        }
        return winners
    }
}