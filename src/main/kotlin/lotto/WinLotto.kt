package lotto

class WinLotto {

    companion object{

        // 2-2. 당첨 번호를 쉼표 기준으로 구분하기
        fun removeWinNumsComma(winNums: String): List<Int> {
            val removeCommaNums = listOf<String>(*winNums.split(",").toTypedArray())
            return removeCommaNums.map { it.toInt() }
        }

        // 3. 보너스 번호 입력 받기
        fun getBonusNum(): Int? {
            //보너스 번호가 양식에 맞게 입력되지 않았을 때의 예외 사항 처리 필요
            return readLine()?.toInt()
        }
    }

}