package lotto


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 숫자가 6개가 아닙니다." }
        require(numbers.distinct().size == 6) { "[ERROR] 중복된 숫자가 존재합니다." }
        require(numbers.all{it.toInt() in 1..45}){"[ERROR] 1 ~ 45까지의 숫자를 입력해야 합니다."}
    }

}
