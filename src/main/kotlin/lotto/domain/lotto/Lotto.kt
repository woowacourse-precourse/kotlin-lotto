package lotto.domain.lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(hasNotDuplicateNumber()) { println(NOT_DUPLICATE_NUMBER)}
        require(isVaildAscendingOrder()) { println(IS_ASCENDING_ORDER)}
    }

    fun getMachingLottoNumberCount(otherNumbers: List<Int>): Int =
        numbers.intersect(otherNumbers).size

    fun isMachingBonusNumber(bonusNumber: Int): Boolean =
        numbers.contains(bonusNumber)

    private fun hasNotDuplicateNumber(): Boolean =
        numbers.size == numbers.distinct().size

    private fun isVaildAscendingOrder(): Boolean =
        numbers == numbers.sorted()

    companion object {
        const val NOT_DUPLICATE_NUMBER = "[ERROR] 로또 번호에 중복되는 숫자가 없어야 합니다."
        const val IS_ASCENDING_ORDER = "[EROOR] 로또 번호는 오름차순으로 정렬되어야 합니다."
    }
}
