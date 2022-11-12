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

    fun printWinningResult(answer: Lotto, bonus: Int) {
        matchLotto(answer, bonus).printWinningResult()
    }
}