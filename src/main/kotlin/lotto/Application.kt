package lotto

import lotto.domain.LottoGame

fun main() {
    try {
        LottoGame().start()
    } catch (_: IllegalArgumentException) {
    }
}