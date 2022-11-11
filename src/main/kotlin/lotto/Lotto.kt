package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(checkDuplication()) {println("[ERROR]")}
    }

    private fun checkDuplication() : Boolean{
        return numbers.filter {
            numbers.contains(it)
        }.count()<=1
    }
}
