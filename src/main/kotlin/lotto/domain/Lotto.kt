package lotto.domain

/**
 * 클래스는 프로퍼티, init 블록, 부 생성자, 메서드, 동반 객체 순으로
 */
class Lotto(private val winningNumber: List<Int>) {
    init {
        // 당첨 번호 초기화
        require(winningNumber.size == 6) { SIZE_BOUNDS_EXCEPTION_MGS }
    }

    // 당첨 번호 vs 로또 번호
    // 5개 일치하는 경우, 보너스 번호 vs 로또 번호
    fun getWinnerList(lottoNumbers: List<List<Int>>, bonusNumber: Int): List<Int> {
        val winners = mutableListOf(0, 0, 0, 0, 0)
        val judgement = Judgement()
        for(lottoNumber in lottoNumbers){
            when(judgement.countMatchNumber(lottoNumber, winningNumber)){
                6 -> winners[FIRST_WINNER_INDEX]++
                5 ->  {
                    if(judgement.checkBonusBall(lottoNumber, bonusNumber)) winners[SECOND_WINNER_INDEX]++
                    else winners[THIRD_WINNER_INDEX]++
                }
                4 -> winners[FORTH_WINNER_INDEX]++
                3 -> winners[FIFTH_WINNER_INDEX]++
            }
        }
        return winners
    }
}