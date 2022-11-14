package lotto

import data.NumberRange
import data.StringResource

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == NumberRange.MAX.number) { StringResource.LENGTHERROR.resource }
        require(numbers.toSet().size == NumberRange.MAX.number) { StringResource.DUPLICATE.resource }
        numbers.forEach {
            require(it in NumberRange.START.number..NumberRange.END.number) {
                StringResource.RANGEERROR.resource
            }
        }
    }

    fun getList(): List<Int> = this.numbers

    fun compareOriginal(lotteryNumbers: Lotto): Int {
        val answer = lotteryNumbers.getList().toSet()
        val lottoNum = this.numbers.toSet()
        val match = answer.intersect(lottoNum).size

        return if (match >= 3) match else 0
    }

    fun compareBonus(lotteryNumbers: Lotto, bonusNumber: Int): Int {
        val quickPick = lotteryNumbers.getList().toMutableList()
        quickPick.add(bonusNumber)

        val compare = quickPick.toSet()
        val answer = this.numbers.toSet()
        return answer.intersect(compare).size

    }

}
