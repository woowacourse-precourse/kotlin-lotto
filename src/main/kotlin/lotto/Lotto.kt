package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)

        Exceptions.checkLotto(numbers)
    }

    fun getNumber():String{
        return numbers.toString()
    }

}
