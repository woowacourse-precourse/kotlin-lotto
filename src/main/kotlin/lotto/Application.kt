package lotto

import lotto.service.LottoService

fun main() {
    val lottoService = LottoService()

    runCatching {
        lottoService.start()
    }.onFailure { exception ->
        println(exception.message)
    }
}