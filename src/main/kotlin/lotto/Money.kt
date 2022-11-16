package lotto


const val LOTTO_PRICE: Int = 1000

class Money {

    var money: String = ""

    enum class WinMoney(private val prize: Int) {
        FifthPlace(5000),
        FourthPlace(50000),
        ThirdPlace(1500000),
        SecondPlace(30000000),
        FirstPlace(2000000000);

        fun getPrize(): Int {
            return prize
        }
    }

    fun isError(): Boolean {
        if (money == "ERROR") {
            return true
        }
        return false
    }

    fun getNumberOfPurchases(): Int {
        return money.toInt() / LOTTO_PRICE
    }

    fun getProfitRate(winningResult: List<Int>): String {
        return formProfitRate(calculateProfitRate(getTotalPrize(winningResult)))
    }

    private fun formProfitRate(d :Double): String{
        return  addComma(roundOff(d))
    }

    private fun getTotalPrize(winningResult: List<Int>): Int {
        var totalPrize = 0
        winningResult.forEachIndexed { index, Num -> totalPrize += WinMoney.values()[index].getPrize() * Num }

        return totalPrize
    }

    private fun roundOff(d: Double): Double {
        return String.format("%.2f", d).toDouble()
    }

    private fun calculateProfitRate(totalPrize: Int): Double {
        return (totalPrize / money.toDouble() * 100)
    }

    fun addComma(d: Double): String {
        return d.toString().replace(Regex("\\B(?=(\\d{3})+(?!\\d))"), ",")
        //문자와공백경계지점이 아닌 3자리숫자 + 숫자 조합 를 여러번 찾는다
    }


}