package lotto.service

import lotto.domain.LottoShop
import lotto.service.dto.LottoDto

object LottoService {

    fun purchaseLotteries(purchaseAmount: Int): List<LottoDto> {
        return LottoShop.purchaseLotteries(purchaseAmount).map { LottoDto(it) }
    }
}