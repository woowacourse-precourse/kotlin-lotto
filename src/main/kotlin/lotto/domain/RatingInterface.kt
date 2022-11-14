package lotto.domain

interface RatingInterface {
    fun getHit(): Int
    fun getPrize(): Int
    fun getBonus(): Boolean
}