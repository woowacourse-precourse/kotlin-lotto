package lotto

class Lottos(private val lottos: List<Lotto>) {


    fun matchLotto(answer: Lotto, bonus : Int) : WinningResult {

        val winningResult = WinningResult()

        lottos.forEach {
            val result = it.matchLotto(answer, bonus)
            winningResult.setWinnigResult(result)
        }
        return winningResult
    }

    fun printLottos() {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { it.printLotto() }
        println()
    }

    fun printWinningResult(answer: Lotto, bonus: Int, money: Int) {
        val winningResult = matchLotto(answer, bonus)
        println("당첨 통계")
        println("---")
        winningResult.printWinningResult()
        countYield(winningResult, money)
    }

    fun countYield(winningResult: WinningResult, money : Int) {
        val sum = winningResult.sumWinningPrize()
        val avg = sum / money.toDouble()

        println("총 수익률은 " + "%.1f".format(avg * 100) + "%입니다.")
    }
}