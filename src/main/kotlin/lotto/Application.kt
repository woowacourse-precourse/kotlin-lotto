package lotto

fun main() {
    var cnt = 0
    var obj = LottoGames(numbers = listOf(0, 0, 0, 0, 0, 0))
    var mt = method_collection()
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
    money = mt.howMuchDoYouHave()
    cnt = mt.howManyBuy(money)
    println()
    println(cnt.toString() + State.many.message)
    //Lotto 클래스 활용해야함!!!
    lottoCollection = mt.showLottoPaper(cnt)
    for (lotto in lottoCollection) {
        println(lotto)
    }
    println()

    //당첨 번호
    println(State.enterLottoNumber.message)
    winningNumber = mt.enterWinningNumber()
    obj = LottoGames(numbers = winningNumber)
    println()

    //보너스 번호
    println(State.enterBonusNumber.message)
    bonusNumber = mt.enterBonusNumber(winningNumber)
    println()

    //당첨 통계
    println(State.end.message)
    println("---")
    for (j in 0 until lottoCollection.size) {
        sameNumber = obj.compareNumbers(lottoCollection[j], winningNumber)
        mt.showWinLottoPaper(lottoCollection[j], sameNumber, bonusNumber)
        winLottoCollection.add(mt.showWinLottoPaper(lottoCollection[j], sameNumber, bonusNumber))
    }

    prizeRating = mt.prizeRate(winLottoCollection)
    profitRate = mt.calculateProfitRate(money, prizeRating)

    println(Prize.three.message + "${prizeRating.get("3")}개")
    println(Prize.four.message + "${prizeRating.get("4")}개")
    println(Prize.five.message + "${prizeRating.get("5")}개")
    println(Prize.fiveBonus.message + "${prizeRating.get("5+1")}개")
    println(Prize.six.message + "${prizeRating.get("6")}개")
    println(Prize.profit1.message + " ${profitRate}" + Prize.profit2.message)

}
