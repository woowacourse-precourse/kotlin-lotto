package lotto

class WinningNumber {
    var winningNumber:List<Int> = listOf()
    fun changeNumberList(winning: String) {
        try{
            winningNumber = winning.split(',').map{it.trim().toInt()}
        }catch(e: IllegalArgumentException){
            println("[ERROR] 로또 번호는 ,로 나뉘어야 하며 숫자로 구성되어야 합니다")
        }
        Lotto(winningNumber)
    }
}