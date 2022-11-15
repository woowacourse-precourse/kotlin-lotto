package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){
            "[ERROR] : 6자리의 숫자가 아닙니다."
        }
        require(numbers.toSet().size == 6) {
            "[ERROR] : 중복된 숫자가 있습니다."
        }
        require(numbers.minOrNull()!! >= 1 && numbers.maxOrNull()!! <= 45) {
            "[ERROR] : 올바른 범위의 숫자를 입력해 주세요.(1~45)"
        }
    }
}
