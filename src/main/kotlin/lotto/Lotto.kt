package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){"[ERROR]"}
        if (numbers.toSet().size != 6){
            throw IllegalArgumentException("[ERROR]")
        }
    }
}
