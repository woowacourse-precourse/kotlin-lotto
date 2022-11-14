package lotto.domain

import kotlin.math.*

/**
 * 클래스는 프로퍼티, init 블록, 부 생성자, 메서드, 동반 객체 순으로
 */
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { SIZE_BOUNDS_EXCEPTION_MGS }
    }

    // 로또 번호와 당첨 번호를 비교한다.
    fun compare(winningNumber: List<Int>): List<Int> {
        val judgement = Judgement()
        val matchCount = judgement.countMatchNumber(numbers, winningNumber)
        return getWinningList(matchCount)
    }

    // 당첨 내역을 출력한다. (5등부터 1등까지 몇개 당첨)
    fun getWinningList(matchCount: Int): List<Int> {
        val winners = mutableListOf(0, 0, 0, 0, 0)
        when (matchCount) {
            3 -> winners[0]++
            4 -> winners[1]++
            6 -> winners[4]++
        }
//        if(matchCount == 5){
//            if(checkBonusBall(numbers)) winners[3]++ // 5개 일치, 보너스 볼 일치
//            else winners[2]++ // 5개 일치
//        }
        return winners
    }
}