package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(checkDuplicate() == 6)
    }

    private fun checkDuplicate(): Int = numbers.toIntArray().toSet().size
}
