package lotto


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)

        if(numbers.size != 6)
            throw IllegalArgumentException("[ERROR] 6개 숫자여야 합니다.")

        if(numbers.toSet().size != 6)
            throw IllegalArgumentException("[ERROR] 중복이 없어야 합니다.")

    }

    fun getNumbers():List<Int>{
        return this.numbers
    }

    override fun toString(): String {
        return numbers.joinToString(", ", "[", "]")
    }

}


