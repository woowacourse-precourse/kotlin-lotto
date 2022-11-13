package lotto.service

import lotto.domain.LottoShop
import lotto.service.dto.LottoDto

object LottoService {

    fun purchaseLotteries(purchaseAmount: Int): List<LottoDto> {
        val lotteries = LottoShop.purchaseLotteries(purchaseAmount)

        return lotteries.map { LottoDto(it) }
    }
}