package lotto

fun main() {
    val viewModel = LottoViewModel()
    val numbers = viewModel.pickRandomNumber()
    val lotto = Lotto(numbers)

    lotto.startGame()
}
