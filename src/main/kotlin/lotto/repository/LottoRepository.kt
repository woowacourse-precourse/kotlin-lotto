package lotto.repository

import lotto.domain.Lotto

object LottoRepository {

    private val repository = mutableListOf<Lotto>()

    fun saveAll(lotteries: List<Lotto>) {
        repository.addAll(lotteries)
    }

    fun findAll(): List<Lotto> {
        return repository.toList()
    }
}