package lotto.model

data class WinningLotto(val number: List<Int>, val bonus:Int)

object LottoData {
    lateinit var winningLotto: WinningLotto
}