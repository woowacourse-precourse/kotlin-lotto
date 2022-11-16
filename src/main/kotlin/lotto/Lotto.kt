package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            println("[ERROR] 숫자 6개를 입력해주십시오")
            throw IllegalArgumentException()
        }
        require(numbers.toSet().size == 6){
            println("[ERROR] 중복된 숫자가 있습니다.")
            throw IllegalArgumentException()
        }
        require(numbers.minOrNull()!! >= 1 && numbers.maxOrNull()!! <= 45){
                println("[ERROR] 1~45 범위의 숫자를 입력해주십시오")
            throw IllegalArgumentException()
        }
    }
}
