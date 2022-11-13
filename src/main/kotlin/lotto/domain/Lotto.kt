package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

/**
 * 클래스는 프로퍼티, init 블록, 부 생성자, 메서드, 동반 객체 순으로
 */
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6자리여야 합니다." }
    }

    // 로또 번호와 당첨 번호를 비교한다.
    fun compare(lottoNumber: List<Int>, winningNumber: List<Int>) {

    }

    // 당첨 내역을 출력한다. (5등부터 1등까지 몇개 당첨)
    fun getWinningList(matchCount: Int): List<Int> {
        return emptyList()
    }

    // 수익률을 출력한다.
    fun getEarningRate(earning: Int, paid: Int): Int {
        return 0
    }
}
