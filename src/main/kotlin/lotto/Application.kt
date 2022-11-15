package lotto

fun main() {
    val service = Service()
    val lotto = __Lotto__(service.buyLotto())
    lotto.printBuyLotto()
    lotto.calculateCorrectCount(service.winningNumbers(), service.bonus())
    lotto.calculateProfit()
    lotto.printResult()
}
