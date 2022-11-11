package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ("[ERROR] 로또 번호는 6개가 필요합니다.") }
        require(checkDuplicate() == 6) { ("[ERROR] 로또 번호에 중복이 있습니다.") }
    }

    private fun checkDuplicate(): Int = numbers.distinct().size

    fun printLottoNumber() = println(numbers.sorted())

    fun confirmWinning(luckyNumber: List<Int>, bonusNumber: Int) : Int{
        var score = luckyNumber.filter{number ->
            numbers.contains(number)
        }.size
        if(numbers.contains(bonusNumber) && score == 5){
            score = 7
        }
        return score
    }
}
