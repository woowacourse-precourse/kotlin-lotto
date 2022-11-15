package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개" }
        if (6 != numbers.distinct().size)
            throw IllegalArgumentException("[ERROR] 로또 번호는 중복 불가")
    }

    fun lottoCorrect(ans: Lotto, bouns: Int): Int {
        var count = 0

        for (n in this.numbers) {
            if (ans.numbers.contains(n))
                count++
        }

        if (count == 5) {
            if (this.numbers.contains(bouns))
                count = 7
        }

        return count
    }
}