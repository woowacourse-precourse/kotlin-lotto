package lotto

import lotto.exception.InputException
import util.Printer

fun main() {
    LottoVendingMachine(
        user = User(),
        machine = Machine(),
        printer = Printer(),
        inputException = InputException()
    ).execution()
}
