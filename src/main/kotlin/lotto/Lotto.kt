package lotto

import data.NumberRange

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == NumberRange.MAX.number) {
            "[ERROR] 로또 번호는 ${NumberRange.MAX.number}개가 필요합니다."
        }
        require(numbers.toSet().size == NumberRange.MAX.number) {
            "[ERROR] 로또 번호는 중복될 수 없습니다."
        }
        require(numbers.first() >= NumberRange.START.number) {
            "[ERROR] ${NumberRange.START.number}보다 작은 번호가 있어서는 안됩니다."
        }
        require(numbers.last() <= NumberRange.END.number) {
            "[ERROR] ${NumberRange.END.number}보다 큰 번호가 있어서는 안됩니다."
        }
    }

    fun getList(): List<Int> {
        return this.numbers
    }
}
