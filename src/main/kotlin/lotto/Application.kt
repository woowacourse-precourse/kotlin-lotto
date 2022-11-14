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
    val inputNumbers = validateWinningNum(pickedNum)
    val winningNum = getWinningNum(inputNumbers)

    println()
    println("보너스 번호를 입력해 주세요.")
    val bonusNum = cs.readLine()
    validateBonusNum(bonusNum)

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

fun validateWinningNum(pickedNum: String): List<String> {
    val inputNumbers = pickedNum.split(",")

    for (valueIndex in inputNumbers.indices) {
        val inputValue = inputNumbers[valueIndex]
        if (inputValue.toIntOrNull() == null) {
            throw IllegalArgumentException(ErrorCode.NUMERIC_REQUIRED.message)
        }
        if (inputValue.toInt() > 45 || inputValue.toInt() < 1) {
            throw IllegalArgumentException(ErrorCode.NUMBER_RANGE_UNQUALIFIED.message)
        }
    }
    return inputNumbers
}

fun getWinningNum(inputNumbers: List<String>): Lotto {
    val winnerNum = mutableListOf<Int>()
    for (valueIndex in inputNumbers.indices) {
        val inputValue = inputNumbers[valueIndex]
        if (winnerNum.contains(inputValue.toInt())) {
            throw IllegalArgumentException(ErrorCode.NUMBER_REPEATED.message)
        }
        winnerNum.add(inputValue.toInt())
    }
    winnerNum.sort()
    return Lotto(winnerNum)
}

fun validateBonusNum(bonusNum: String) {
    if (bonusNum.toIntOrNull() == null) {
        throw IllegalArgumentException(ErrorCode.NUMERIC_REQUIRED.message)
    }
    if (bonusNum.toInt() > 45 || bonusNum.toInt() < 1) {
        throw IllegalArgumentException(ErrorCode.NUMBER_RANGE_UNQUALIFIED.message)
    }
}

fun showWinningStatistics(result: List<Int>){
    print("\n당첨 통계\n" +
            "---\n" +
            "3개 일치 (5,000원) - ${result[0]}개\n" +
            "4개 일치 (50,000원) - ${result[1]}개\n" +
            "5개 일치 (1,500,000원) - ${result[2]}개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ${result[3]}개\n" +
            "6개 일치 (2,000,000,000원) - ${result[4]}개\n"
    )
}