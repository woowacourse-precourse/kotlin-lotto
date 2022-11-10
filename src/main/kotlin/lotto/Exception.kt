package lotto

class Exception {

    /**
     *  각 조건에 따라 예외를 던져주는 함수
     */
    fun throwException(input: String){
        when{
            !getIsInputFormRight(input) -> throw IllegalArgumentException("[ERROR] 입력값이 올바른 형식이 아닙니다.")
            !hasDistinctNumber(input) -> throw IllegalArgumentException("[ERROR] 로또 번호는 서로 중복되지 않은 숫자여야 합니다.")
            !getIsSizeSix(input) -> throw IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.")
            !getIsBetweenOneAndFortyFive(input) -> throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }

    /**
     * 옳은 형식으로 입력하지 않았다면 false 를 반환해주는 함수
     */
    private fun getIsInputFormRight(input: String): Boolean{
        val inputSymbols = input.split(",")
        for (index in inputSymbols.indices){
            try {
                inputSymbols[index].toInt()
            }
            catch (e: NumberFormatException){
                return false
            }
        }
        return true
    }

    /**
     *  중복된 숫자들이 있으면 false 를 반환해주는 함수
     */
    private fun hasDistinctNumber(input: String): Boolean{
        val inputSymbols = input.split(",")
        return inputSymbols.size == inputSymbols.distinct().size
    }

    /**
     *  숫자가 6개가 넘어가면 false 를 반환해주는 함수
     */
    private fun getIsSizeSix(input: String): Boolean{
        val inputSymbols = input.split(",")
        return inputSymbols.size == 6
    }

    /**
     * 1 ~ 45 이외의 숫자가 있으면 false 를 반환해주는 함수
     */
    private fun getIsBetweenOneAndFortyFive(input: String):  Boolean{
        val inputSymbols = input.split(",")
        for (index in inputSymbols.indices){
            if (inputSymbols[index].toInt() !in 1..45)
                return false
        }
        return true
    }
}
