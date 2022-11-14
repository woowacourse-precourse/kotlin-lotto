package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console as cs

fun main() {
    println("구입금액을 입력해 주세요.")
    val amountPaid = cs.readLine()
}

enum class ErrorCode(val message: String) {
    NUMERIC_REQUIRED("[ERROR] 숫자만 입력해주세요"),
    COMMA_REQUIRED("[ERROR] 쉼표로 숫자를 구분해주세요"),
    PRICE_UNQUALIFIED("[ERROR] 1000원 단위로 입력해주세요"),
    NUMBER_RANGE_UNQUALIFIED("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
}

fun issueLotto(): List<Int> {
    val lottoNum = mutableListOf<Int>()
    while (lottoNum.size < 6) {
        val randomNumber = Randoms.pickNumberInRange(1, 45)
        if (!lottoNum.contains(randomNumber)) {
            lottoNum.add(randomNumber)
        }
    }

    return lottoNum
}