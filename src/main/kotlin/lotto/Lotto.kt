package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        if(6 != numbers.distinct().size)
            throw IllegalArgumentException("[ERROR] 로또 번호는 중복 불가")
    }
    val lottoNumber = numbers
}