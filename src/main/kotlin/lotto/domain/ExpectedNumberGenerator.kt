package lotto.domain

class ExpectedNumberGenerator(private val expected: List<List<Int>>) : Generator {
    private var index = 0

    override fun generateNumbers(): List<Int> {
        if(index >= expected.size) {
            index = 0
        }
        return expected[index++]
    }
}