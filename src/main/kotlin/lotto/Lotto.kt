package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ("[ERROR] 로또 번호는 6개가 필요합니다.") }
        require(checkDuplicate() == 6) { ("[ERROR] 로또 번호에 중복이 있습니다.") }
    }

    private fun checkDuplicate(): Int = numbers.distinct().size

    fun printLottoNumber() = println(numbers.sorted())

    fun confirmWinning(luckyNumber: List<Int>, bonusNumber: Int) : Int{
        var rank = luckyNumber.filter{number ->
            numbers.contains(number)
        }.size
        if(numbers.contains(bonusNumber) && rank == 5){
            rank = 7
        }
        return when(rank){
            3 -> 5
            4 -> 4
            5 -> 3
            7 -> 2
            6 -> 1
            else -> 0
        }
    }
}
