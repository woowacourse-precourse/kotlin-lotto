package lotto

fun main() {
    val money = User().getMoney()
    val numberOfLotto = money / 1000
    val lotto = LottoGenerator().generateLotto(numberOfLotto)
    println()
    LottoPrinter().printLotto(lotto)
}
