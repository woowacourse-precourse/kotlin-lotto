package lotto.domain

class Comparator() {
    private val result: HashMap<String, Int> = hashMapOf("" to 0)
    private var sum = 0

    fun getMoney(): Int {
        return sum
    }

    fun showLottoResult(lottoResult: MutableList<Int>): HashMap<String, Int> {
        for (index in 0 until lottoResult.size) {
            showNumberOfCase(index, lottoResult[index])
        }
        return result
    }

    private fun showNumberOfCase(index: Int, count: Int) {

        when (count) {
            3 -> {
                lottoResult("5등")
                sum += 5000
            }

            4 -> {
                lottoResult("4등")
                sum += 50000
            }

            5 -> {
                lottoResult("3등")
                sum += 1500000
            }

            6 -> if (CheckLotto.checkBonus[index]) {
                lottoResult("2등")
                sum += 30000000
            } else {
                lottoResult("1등")
                sum += 2000000000
            }
        }
    }

    private fun lottoResult(rank: String) {

        if (rank in result) {
            result[rank] = result.getValue(rank).plus(1)
        } else {
            result[rank] = 1
        }
    }


}