package lotto.domain

/**
 * 클래스는 프로퍼티, init 블록, 부 생성자, 메서드, 동반 객체 순으로
 */
class Lotto(private val winningNumber: List<Int>) {
    init { // 당첨 번호 초기화
        require(winningNumber.size == 6) { SIZE_BOUNDS_EXCEPTION_MGS }
    }

    // 당첨 번호 vs 로또 번호
    // 5개 일치하는 경우, 보너스 번호 vs 로또 번호
    fun compare(lottoNumbers: List<List<Int>>, bonusNumber: Int) {
        val winners = mutableListOf(0, 0, 0, 0, 0)
        for(lottoNumber in lottoNumbers){
            val judgement = Judgement()
            val matchCount = judgement.countMatchNumber(lottoNumber, winningNumber)
            if(matchCount == 5){
                if(checkBonusBall(lottoNumber, bonusNumber)) winners[SECOND_WINNER_INDEX]++
                else winners[THIRD_WINNER_INDEX]++
                continue
            }
            when(matchCount){
                6 -> winners[FIRST_WINNER_INDEX]++
                4 -> winners[FORTH_WINNER_INDEX]++
                3 -> winners[FIFTH_WINNER_INDEX]++
            }
        }
        println(winners)
    }

    private fun checkBonusBall(lottoNumber: List<Int>, bonusNumber: Int): Boolean {
        return lottoNumber.contains(bonusNumber)
    }
}