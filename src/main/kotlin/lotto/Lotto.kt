package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        if(numbers.size != 6) {
            println("[ERROR] 입력 갯수가 잘못되었습니다.")
            throw IllegalArgumentException("[ERROR] 입력 갯수가 잘못되었습니다.")
        }

        val isDuplication = numbers.size == numbers.toSet().size
        if(!isDuplication) {
            println("[ERROR] 중복되는 숫자가 있습니다.")
            throw IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.")
        }

        numbers.forEach { num ->
            if(num !in 1..45) {
                println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        }
    }

    fun bonusNumberException(bonusNumber: Int) {
        if(bonusNumber !in 1 .. 45) {
            println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }

        if(numbers.contains(bonusNumber)) {
            println("[ERROR] 중복되는 숫자가 있습니다.")
            throw IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.")
        }
    }

    fun checkLotto(myLotto: List<Int>, bonusNumber: Int): Int {
        val union = myLotto + numbers
        var sameNumCnt = union.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct().size
        if(sameNumCnt == 6) return 4

        if(myLotto.contains(bonusNumber)) sameNumCnt += 1

        return when(sameNumCnt) {
            3 -> 0
            4 -> 1
            5 -> 2
            6 -> 3
            else -> 5
        }
    }
}
