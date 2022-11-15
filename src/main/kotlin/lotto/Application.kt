package lotto

fun main() {
    val numbers = LottoViewModel.pickRandomNumber()
    val lotto = Lotto(numbers)

    lotto.startGame()
}
