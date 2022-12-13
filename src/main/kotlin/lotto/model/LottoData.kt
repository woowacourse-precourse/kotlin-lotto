package lotto.model

import kotlin.properties.Delegates

object LottoData {
    lateinit var winningNumber: List<Int>
    var bonusNumber by Delegates.notNull<Int>()
}