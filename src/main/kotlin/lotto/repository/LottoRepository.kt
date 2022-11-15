package lotto.repository

import lotto.domain.Lotto

object LottoRepository {

    private var repository = listOf<Lotto>()

    fun saveAll(lotteries: List<Lotto>) {
        repository = lotteries
    }

    fun findAll(): List<Lotto> = repository
}