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
            "[ERROR] 로또 번호는 ${NumberRange.START.number}부터 ${NumberRange.END.number} 사이의 숫자여야 합니다."
        }
        require(numbers.last() <= NumberRange.END.number) {
            "[ERROR] 로또 번호는 ${NumberRange.START.number}부터 ${NumberRange.END.number} 사이의 숫자여야 합니다."
        }
    }

    fun getList(): List<Int> {
        return this.numbers
    }
}
