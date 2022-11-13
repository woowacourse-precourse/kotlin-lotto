package lotto.domain

class Referee {
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