package lotto

import camp.nextstep.edu.missionutils.Console.readLine

enum class State(val message: String) {
    start("구입금액을 입력해 주세요."),
    many("개를 구매했습니다."),
    enterLottoNumber("당첨 번호를 입력해 주세요."),
    enterBonusNumber("보너스 번호를 입력해 주세요."),
    end("당첨 통계");
}

enum class Prize(val message: String) {
    three("3개 일치 (5,000원) - "),
    four("4개 일치 (50,000원) - "),
    five("5개 일치 (1,500,000원) - "),
    fiveBonus("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    six("6개 일치 (2,000,000,000원) - "),
    profit1("총 수익률은"),
    profit2("%입니다.")
}

enum class error(val message: String) {
    inputSomething("[ERROR] 아무것도 입력하지 않으셨습니다"), //아무것도 입력하지 않으셨습니다
    wrongInput("[ERROR] 잘못 입력하셨습니다"), //잘못 입력하셨습니다
    onlyNumberInput("[ERROR] 숫자만 입력해야 합니다"), //숫자만 입력해야 합니다
    sameNumberInLotto("[ERROR] 중복된 번호가 있습니다"), //중복된 번호가 있습니다
    sameNumberInBonus("[ERROR] 로또 번호와 겹칩니다"), //로또 번호와 겹칩니다
    wrongNumber("[ERROR] 보너스 번호는 1~45 사이"); //보너스 번호는 1~45 사이

}

fun howMuchDoYouHave(): Int {
    val usermoney = readLine()
    var money = ""
    if (usermoney == "") {
        throw IllegalArgumentException(error.inputSomething.message)
    }
    for (cash in 0 until usermoney.length) {
        if (usermoney[cash].isDigit()) {
            money += usermoney[cash]
        }
        else if (!usermoney[cash].isDigit()) {
            throw IllegalArgumentException(error.onlyNumberInput.message)
        }
    }
    return money.toInt()
}


fun howManyBuy(money: Int): Int {
    val answer = money / 1000
    return answer
}

fun enterWinningNumber(): List<Int> {
    val userCheck = readLine()
    val winningNumber = mutableListOf<Int>()
    val number = userCheck.split(',')
    if (!userCheck.contains(',')) {
        throw IllegalArgumentException(error.wrongInput.message)
    }
    for (num in 0 until number.size) {
        // 번호가 중복된 경우 에러 유발해야함
        if (winningNumber.contains(number[num].toInt())) {
            throw IllegalArgumentException(error.sameNumberInLotto.message)
        }
        winningNumber.add(number[num].toInt())
    }
    return winningNumber
}

fun enterBonusNumber(winningNumbers: List<Int>): Int {
    val userCheck = readLine()
    if (!"^[0-9]*$".toRegex().matches(userCheck)) {
        throw IllegalArgumentException(error.wrongInput.message)
    }
    // 보너스 번호가 로또 번호와 같은 경우
    if (winningNumbers.contains(userCheck.toInt())) {
        throw IllegalArgumentException(error.sameNumberInBonus.message)
    }
    // 번호 입력을 1~45사이 안한 경우
    else if (userCheck.toInt() > 45 || userCheck.toInt() < 1) {
        throw IllegalArgumentException(error.wrongNumber.message)
    }
    return userCheck.toInt()
}

fun showLottoPaper(cnt: Int): MutableList<List<Int>> {
    var lottoCollection = mutableListOf<List<Int>>()
    var obj = LottoGames(numbers = listOf(0, 0, 0, 0, 0, 0))
    for (paper in 0 until cnt) {
        lottoCollection.add(obj.pickLottoNumbers())
    }
    return lottoCollection
}

fun showWinLottoPaper(lotto: List<Int>, sameNumber: Int, bonusNumber: Int): String {
    var winLottoPaper = ""
    if (sameNumber == 5) {
        if (lotto.contains(bonusNumber)) {
            winLottoPaper = "5+1"
            return winLottoPaper
        } else if (!lotto.contains(bonusNumber)) {
            winLottoPaper = "5"
            return winLottoPaper
        }
    }
    winLottoPaper = sameNumber.toString()
    return winLottoPaper
}

fun prizeRate(winLottoCollection: List<String>): Map<String, Int> {
    var prizeRate = mutableMapOf("3" to 0, "4" to 0, "5" to 0, "5+1" to 0, "6" to 0)
    if (winLottoCollection.contains("3")) {
        prizeRate += "3" to winLottoCollection.count { it == "3" }
    }
    if (winLottoCollection.contains("4")) {
        prizeRate += "4" to winLottoCollection.count { it == "4" }
    }
    if (winLottoCollection.contains("5")) {
        prizeRate += "5" to winLottoCollection.count { it == "5" }
    }
    if (winLottoCollection.contains("5+1")) {
        prizeRate += "5+1" to winLottoCollection.count { it == "5+1" }
    }
    if (winLottoCollection.contains("6")) {
        prizeRate += "6" to winLottoCollection.count { it == "6" }
    }
    return prizeRate
}

fun calculateProfitRate(price: Int, prizeRating: Map<String, Int>): Double {
    var profitRate = 0.0
    var totalreward = 0.0
    var reward = listOf(5000, 50000, 1500000, 30000000, 2000000000)
    totalreward += prizeRating.getValue("3") * reward[0]
    totalreward += prizeRating.getValue("4") * reward[1]
    totalreward += prizeRating.getValue("5") * reward[2]
    totalreward += prizeRating.getValue("5+1") * reward[3]
    totalreward += prizeRating.getValue("6") * reward[4]
    profitRate = String.format("%.2f", (totalreward / price) * 100).toDouble() // 둘째자리에서 반올림
    return profitRate
}


fun main() {
    var cnt = 0
    var obj = LottoGames(numbers = listOf(0, 0, 0, 0, 0, 0))
    var winningNumber = listOf<Int>()
    var bonusNumber = 0
    var lottoCollection = mutableListOf<List<Int>>()
    var sameNumber = 0
    var winLottoCollection = mutableListOf<String>()
    var prizeRating = mapOf<String, Int>()
    var money = 0
    var profitRate = 0.0

    //시작
    println(State.start.message)

    //구매 개수
    money = howMuchDoYouHave()
    cnt = howManyBuy(money)
    println()
    println(cnt.toString() + State.many.message)
    //Lotto 클래스 활용해야함!!!
    lottoCollection = showLottoPaper(cnt)
    for (lotto in lottoCollection) {
        println(lotto)
    }
    println()

    //당첨 번호
    println(State.enterLottoNumber.message)
    winningNumber = enterWinningNumber()
    obj = LottoGames(numbers = winningNumber)
    println()

    //보너스 번호
    println(State.enterBonusNumber.message)
    bonusNumber = enterBonusNumber(winningNumber)
    println()

    //당첨 통계
    println(State.end.message)
    println("---")
    for (j in 0 until lottoCollection.size) {
        sameNumber = obj.compareNumbers(lottoCollection[j], winningNumber)
        showWinLottoPaper(lottoCollection[j], sameNumber, bonusNumber)
        winLottoCollection.add(showWinLottoPaper(lottoCollection[j], sameNumber, bonusNumber))
    }

    prizeRating = prizeRate(winLottoCollection)
    profitRate = calculateProfitRate(money, prizeRating)

    println(Prize.three.message + "${prizeRating.get("3")}개")
    println(Prize.four.message + "${prizeRating.get("4")}개")
    println(Prize.five.message + "${prizeRating.get("5")}개")
    println(Prize.fiveBonus.message + "${prizeRating.get("5+1")}개")
    println(Prize.six.message + "${prizeRating.get("6")}개")
    println(Prize.profit1.message + " ${profitRate}" + Prize.profit2.message)


}
