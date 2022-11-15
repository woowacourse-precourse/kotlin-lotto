package lotto

import kotlin.math.round

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            "[ERROR] : 6자리의 숫자가 아닙니다."
        }
        require(numbers.toSet().size == 6) {
            "[ERROR] : 중복된 숫자가 있습니다."
        }
        require(numbers.minOrNull()!! >= 1 && numbers.maxOrNull()!! <= 45) {
            "[ERROR] : 올바른 범위의 숫자를 입력해 주세요.(1~45)"
        }
    }

    fun run(lists: MutableList<List<Int>>, numbers: List<Int>, bonus: Int, money: Int) {
        var emd1 = 0
        var emd2 = 0
        var emd3 = 0
        var emd4 = 0
        var emd5 = 0
        var moneyResult = 0

        println("당첨 통계")

        for (i in 0 until lists.size) {
            val union = lists[i] + numbers
            val intersection = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
            if (intersection.size == 3) {
                emd5 += 1
                moneyResult += 5000
            }
            if (intersection.size == 4) {
                emd4 += 1
                moneyResult += 500000
            }
            if (!(lists[i].contains(bonus)) && intersection.size == 5) {
                emd3 += 1
                moneyResult += 1500000
            }
            if (lists[i].contains(bonus) && intersection.size == 5) {
                emd2 += 1
                moneyResult += 30000000
            }
            if (intersection.size == 6) {
                moneyResult += 2000000000
                emd1 += 1
            }
        }

        println("3개 일치 (5,000원) - ${emd5}개")
        println("4개 일치 (50,000원) - ${emd4}개")
        println("5개 일치 (1,500,000원) - ${emd3}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${emd2}개")
        println("6개 일치 (2,000,000,000원) - ${emd1}개")
        println("총 수익률은 ${round(moneyResult / money.toFloat() * 1000) / 10}%입니다.")
    }
}
