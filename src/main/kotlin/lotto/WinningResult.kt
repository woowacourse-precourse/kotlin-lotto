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

}