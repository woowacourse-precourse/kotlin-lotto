package lotto

object Exceptions {
    fun checkMoney(money: String) {
        if (money.any { it !in '0'..'9' }) {
            throw IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.")
        }
        if ((money.toInt() % 1000) != 0) {
            throw IllegalArgumentException("[ERROR] 1000 단위로 입력해야 합니다.")
        }
        if (money.toInt() < 1000) {
            throw IllegalArgumentException("[ERROR] 1000 이상 입력해야 합니다.")
        }
    }
    fun checkLotto(numbers: List<Int>){
        if(numbers.any { it !in  1 .. 45 }){
            throw IllegalArgumentException("[ERROR] 1 ~ 45사이 숫자를 입력해야 합니다.")
        }
        if(numbers.toSet().size != numbers.size){
            throw IllegalArgumentException("[ERROR] 서로 다른 숫자를 입력해야 합니다.")
        }
    }
    fun checkWiningNumber(winningNumber: List<String>) { //"1, 2, 3, 4, 5, 6"

        require(winningNumber.size == 6 ){Message.ERROR_MASSAGE}

        if (winningNumber.any { it.contains(Regex("\\D")) }
        ) {
            println("[ERROR] 숫자를 입력해야 합니다.")
            throw IllegalArgumentException()
        }
        if(winningNumber.any { it.toInt() !in 1 .. 45}){
            throw IllegalArgumentException("[ERROR] 1 ~ 45사이 숫자를 입력해야 합니다.")
        }
        if (winningNumber.toSet().size != winningNumber.size) {
            throw IllegalArgumentException("[ERROR] 서로 다른 숫자를 입력해야 합니다.")
        }
    }

    fun checkBonus(winningNumber: List<String>, bonus: String) {

        if (bonus.contains(Regex("\\D"))) {
            throw IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.")
        }
        if (winningNumber.any { it == bonus }) {
            throw IllegalArgumentException("[ERROR] 당첨번호와 다른 숫자를 입력해야 합니다.")
        }
    }
}