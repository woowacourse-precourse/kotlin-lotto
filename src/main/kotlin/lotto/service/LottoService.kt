package lotto.service

import lotto.domain.LottoShop
import lotto.repository.LottoRepository
import lotto.service.dto.LottoDto

object LottoService {

    fun purchaseLotteries(purchaseAmount: Int): List<LottoDto> {
        val lotteries = LottoShop.purchaseLotteries(purchaseAmount)
        LottoRepository.saveAll(lotteries)
        return lotteries.map { LottoDto(it) }
    }
}