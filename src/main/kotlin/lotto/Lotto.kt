package lotto

import java.util.*

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getMatchingNumber(lottoNumber: List<List<Int>>) {
        // 발행된 로또와 당첨 번호를 비교한다.
        // 일치하는 번호 개수는 (로또길이 - (당첨번호 - 로또번호))로 구할 수 있다.
        // 일치하는 번호 개수가 5이면 보너스 번호 일치 여부를 확인한다.

        var matchingResult = mutableListOf<String>()
        for (randLotto in lottoNumber) {
            var matchingNumber = (LOTTO_SIZE - (numbers.minus(randLotto)).size).toString()
            if (matchingNumber == "5") {
                matchingNumber = matchBonusNumber(randLotto)
            }
            matchingResult.add(matchingNumber)
        }
        println(matchingResult)
    }

    fun matchBonusNumber(randLotto: List<Int>): String{
        if (Seller.bonusNumber.toInt() in randLotto) {
            return "5bonus"
        }
        return "5"
    }
}
