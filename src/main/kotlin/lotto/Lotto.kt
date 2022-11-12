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
        numbers.forEach {
            require(it in NumberRange.START.number..NumberRange.END.number) {
                "[ERROR] 로또 번호는 ${NumberRange.START.number}부터 ${NumberRange.END.number} 사이의 숫자여야 합니다."
            }
        }
    }

    fun getList(): List<Int> {
        return this.numbers
    }

    fun compareOriginal(lotteryNumbers: Lotto): Int {
        val answer = lotteryNumbers.getList().toSet()
        val lottoNum = this.numbers.toSet()
        val match = answer.intersect(lottoNum).size

        return if (match >= 3) { match } else { 0 }
    }

    fun compareBonus(lotteryNumbers: Lotto, bonusNumber: Int): Boolean {
        val answer = lotteryNumbers.getList().toSet()
        val bonusNumbers = this.numbers.toMutableList()
        bonusNumbers.add(bonusNumber)
        val lottoNum = bonusNumbers.toSet()

        if (answer.intersect(lottoNum).size == 6) return true
        return false

    }

}
