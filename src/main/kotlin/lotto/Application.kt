package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console as cs

fun main() {
    println("구입금액을 입력해 주세요.")
    val amountPaid = cs.readLine()
    val quantity = validateAmount(amountPaid)
    println()
    println("${quantity}개를 구매했습니다.")

    val purchasedLotto = mutableListOf<Lotto>()
    for (lottoQuantity in 1..quantity) {
        val newLotto = issueLotto()
        purchasedLotto.add(newLotto)
    }

    println()
    println("당첨 번호를 입력해 주세요.")
    val pickedNum = cs.readLine()
    val winningNum = validateWinningNum(pickedNum)
}

enum class ErrorCode(val message: String) {
    NUMERIC_REQUIRED("[ERROR] 숫자만 입력해주세요"),
    COMMA_REQUIRED("[ERROR] 쉼표로 숫자를 구분해주세요"),
    PRICE_UNQUALIFIED("[ERROR] 1000원 단위로 입력해주세요"),
    NUMBER_RANGE_UNQUALIFIED("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NUMBER_REPEATED("[ERROR] 중복된 숫자입니다")
}

fun issueLotto(): Lotto {
    val lottoNum = mutableListOf<Int>()
    while (lottoNum.size < 6) {
        val randomNumber = Randoms.pickNumberInRange(1, 45)
        if (!lottoNum.contains(randomNumber)) {
            lottoNum.add(randomNumber)
        }
    }
    lottoNum.sort()
    println(lottoNum)
    return Lotto(lottoNum)
}
fun validateAmount(amountPaid: String): Int{
    if(amountPaid.toIntOrNull() == null){
        throw IllegalArgumentException(ErrorCode.NUMERIC_REQUIRED.message)
    }

    val price = amountPaid.toInt()
    if(price%1000>0){
        throw IllegalArgumentException(ErrorCode.PRICE_UNQUALIFIED.message)
    }

    return price/1000
}

fun validateWinningNum(pickedNum: String): Lotto {
    val winnerNum = mutableListOf<Int>()
    val inputNumbers = pickedNum.split(",")

    for (valueIndex in inputNumbers.indices) {
        val inputValue = inputNumbers[valueIndex]
        if (inputValue.toIntOrNull() == null) {
            throw IllegalArgumentException(ErrorCode.NUMERIC_REQUIRED.message)
        }
        if (inputValue.toInt() > 45 || inputValue.toInt() < 1) {
            throw IllegalArgumentException(ErrorCode.NUMBER_RANGE_UNQUALIFIED.message)
        }
        if(winnerNum.contains(inputValue.toInt())){
            throw IllegalArgumentException(ErrorCode.NUMBER_REPEATED.message)
        }
        winnerNum.add(inputValue.toInt())
    }
    winnerNum.sort()

    return Lotto(winnerNum)
}