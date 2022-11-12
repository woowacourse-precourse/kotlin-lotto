package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine


/*
2주차 피드백
1. 변수 이름에 자료형, 자료 구조 사용 X
2. 함수 길이 15라인 넘어가지 않게, 넘어가면 분리
3. 핵심 기능에 가까운 부분부터 작게 테스트를 만들어 나간다.
4. else를 지양한다.

ex)
큰 단위의 테스트
숫자 야구 게임을 시작해서 사용자가 숫자를 입력하면, 컴퓨터 숫자와 비교하여 그 결과를 알려준다.

작은 단위의 테스트
사용자의 숫자가 컴퓨터의 숫자와 하나도 일치하지 않으면 낫싱을 출력한다.
사용자의 숫자가 컴퓨터의 숫자와 1개는 일치하고, 위치가 다르면 1볼을 출력한다.
*/

// Enum 클래스 적용해 프로그래밍을 구현한다.
enum class State(val message: String) {
    start("구입금액을 입력해 주세요."),
    many("개를 구매했습니다."),
    enterLottoNumber("당첨 번호를 입력해 주세요."),
    enterBonusNumber("보너스 번호를 입력해 주세요."),
    end("당첨 통계");

    //함수 추가 가능함

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

enum class Error(val message: String){
    sameNumberInBonus("[ERROR] 로또 번호와 겹칩니다"),
    wrongNumber("[ERROR] 보너스 번호는 1~45 사이")

}

fun howMuchDoYouHave() : Int{
    var money = readLine().toInt()
    return money
}


fun howManyBuy(money : Int): Int {
    var answer = money / 1000
    return answer
}

fun enterWinningNumber(): List<Int> {
    var userCheck = readLine()
    var winningNumber = mutableListOf<Int>()
    var number = userCheck.split(',')
    for (num in 0 until number.size) {
        // 번호가 중복된 경우 에러 유발해야함
        winningNumber.add(number[num].toInt())
    }
    return winningNumber
}

fun enterBonusNumber(winningNumbers: List<Int>): Int {
    var userCheck = readLine().toInt()
    // 보너스 번호가 로또 번호와 같은 경우
    if (winningNumbers.contains(userCheck)) {
        throw IllegalArgumentException(Error.sameNumberInBonus.message)
    }
    // 번호 입력을 1~45사이 안한 경우
    else if (userCheck > 45 || userCheck < 1) {
        throw IllegalArgumentException(Error.wrongNumber.message)
    }
    return userCheck
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
            winLottoPaper="5+1"
            return winLottoPaper
        } else if (!lotto.contains(bonusNumber)) {
            winLottoPaper="5"
            return winLottoPaper
        }
    }
    winLottoPaper=sameNumber.toString()
    return winLottoPaper
}

fun prizeRate(winLottoCollection: List<String>) : Map<String,Int>{
    var prizeRate = mutableMapOf("3" to 0, "4" to 0, "5" to 0, "5+1" to 0, "6" to 0)
    if (winLottoCollection.contains("3")){
        prizeRate += "3" to  winLottoCollection.count { it == "3" }
    }
    if (winLottoCollection.contains("4")){
        prizeRate += "4" to  winLottoCollection.count { it == "4" }
    }
    if (winLottoCollection.contains("5")){
        prizeRate += "5" to  winLottoCollection.count { it == "5" }
    }
    if (winLottoCollection.contains("5+1")){
        prizeRate += "5+1" to  winLottoCollection.count { it == "5+1" }
    }
    if (winLottoCollection.contains("6")){
        prizeRate += "6" to  winLottoCollection.count { it == "6" }
    }
    return prizeRate
}

fun calculateProfitRate(price : Int, prizeRating : Map<String, Int>) : Double {
    var profitRate=0.0
    var totalreward=0.0
    var reward = listOf(5000,50000,1500000,30000000,2000000000)
    totalreward+=prizeRating.getValue("3")*reward[0]
    totalreward+=prizeRating.getValue("4")*reward[1]
    totalreward+=prizeRating.getValue("5")*reward[2]
    totalreward+=prizeRating.getValue("5+1")*reward[3]
    totalreward+=prizeRating.getValue("6")*reward[4]
    profitRate=String.format("%.2f", (totalreward/price)*100).toDouble() // 둘째자리에서 반올림
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
    var money=0

    //시작
    println(State.start.message)

    //구매 개수
    money=howMuchDoYouHave()
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

    prizeRating=prizeRate(winLottoCollection)

    println(Prize.three.message + "${prizeRating.get("3")}개")
    println(Prize.four.message + "${prizeRating.get("4")}개")
    println(Prize.five.message + "${prizeRating.get("5")}개")
    println(Prize.fiveBonus.message + "${prizeRating.get("5+1")}개")
    println(Prize.six.message + "${prizeRating.get("6")}개")

    calculateProfitRate(money, prizeRating)
}
