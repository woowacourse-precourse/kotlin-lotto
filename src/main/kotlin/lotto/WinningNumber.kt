package lotto

class WinningNumber {
    var winningNumber:List<Int> = listOf()
    fun changeNumberList(winning: String) {
        winningNumber = winning.split(',').map{it.toInt()}
        print(winningNumber)
        Lotto(winningNumber)
    }
}