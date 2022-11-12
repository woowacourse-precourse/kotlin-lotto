package lotto

class WinningResult {

    var first : Int = 0
    var second : Int = 0
    var third : Int = 0
    var fourth : Int = 0
    var fifth : Int = 0

    fun setWinnigResult(grade : LottoGrade) {
        when(grade) {
            LottoGrade.FIRST -> first++
            LottoGrade.SECOND -> second++
            LottoGrade.THIRD -> third++
            LottoGrade.FOURTH -> fourth++
            LottoGrade.FIFTH -> fifth++
        }
    }

    fun printWinningResult() {
        println(LottoGrade.FIFTH.toString() + fifth + "개")
        println(LottoGrade.FOURTH.toString() + fourth + "개")
        println(LottoGrade.THIRD.toString() + third + "개")
        println(LottoGrade.SECOND.toString() + second + "개")
        println(LottoGrade.FIRST.toString() + first + "개")
    }

    fun sumWinningPrize() : Int = LottoGrade.FIFTH.prize * fifth + LottoGrade.FOURTH.prize * fourth + LottoGrade.THIRD.prize * third +
            LottoGrade.SECOND.prize * second + LottoGrade.FIRST.prize * first

}