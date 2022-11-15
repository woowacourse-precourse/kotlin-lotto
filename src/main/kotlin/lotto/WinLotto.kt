package lotto

class WinLotto {

    companion object{

        fun removeWinNumsComma(winNums: String): List<Int> {
            val removeCommaNums = listOf<String>(*winNums.split(",").toTypedArray())
            return removeCommaNums.map { it.toInt() }
        }

    }

}