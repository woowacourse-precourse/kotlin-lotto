package lotto

const val MIN =1
const val MAX =45

val purchase = Purchase(Purchase.inputPrice())

const val ERROR_NO_INPUT = "[ERROR] 구입 금액을 입력하지 않았습니다."
const val ERROR_NOT_INT = "[ERROR] 구입 금액에는 숫자만 입력해야합니다."
const val ERROR_1000UNIT = "[ERROR] 구입 금액이 1,000원 단위여야 합니다."


fun main() {
    Lotto.publish(purchase.count)
    Lotto.printCount()
    LottoWin.input()
    WinningStatistics.calculateWin(Lotto.lottoes)
    WinningStatistics.print(purchase.price)
}
