package lotto

class WinLotto {

    companion object{

        // 2-2. 당첨 번호를 쉼표 기준으로 구분하기
        fun removeWinNumsComma(winNums: String): List<Int> {
            val removeCommaNums = listOf<String>(*winNums.split(",").toTypedArray())
            return removeCommaNums.map { it.toInt() }
        }

    }

}