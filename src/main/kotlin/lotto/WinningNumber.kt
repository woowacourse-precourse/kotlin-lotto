package lotto

class WinningNumber {
    var winningNumber: List<Int> = listOf()
    fun changeNumberList(winning: String) {
        try {
            winningNumber = winning.split(',').map { it.trim().toInt() }
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 로또 번호는 ,로 나뉘어야 하며 숫자로 구성되어야 합니다")
        }
        Lotto(winningNumber)
    }

    fun checkBonus(bonus: Int) {
        if (winningNumber.contains(bonus)) {
            throw IllegalArgumentException("[ERROR] 보너스 번호는 기존 당첨번호와 중복되지 않아야 합니다.")
        }
        require(bonus in 1..45) { "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." }
    }
}