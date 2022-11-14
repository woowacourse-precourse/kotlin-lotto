package lotto

object ExceptionHandler {

    /**
     *  각 조건에 따라 예외를 던져주는 함수
     */
    fun throwException(numbers: List<Int>){
        when{
            !hasDistinctNumber(numbers) -> throw IllegalArgumentException("[ERROR] 로또 번호는 서로 중복되지 않은 숫자여야 합니다.")
            !getIsSizeSix(numbers) -> throw IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.")
            !getIsBetweenOneAndFortyFive(numbers) -> throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }

    /**
     *  숫자가 아니라면 false 를 반환해주는 함수
     */
    fun getIsInputFormRight(inputSymbol: String): Boolean{
        try {
            inputSymbol.toInt()
        }
        catch (e: NumberFormatException){
            return false
        }
        return true
    }

    /**
     *  중복된 숫자들이 있으면 false 를 반환해주는 함수
     */
    fun hasDistinctNumber(numbers: List<Int>): Boolean{
        return numbers.size == numbers.distinct().size
    }

    /**
     *  숫자가 6개가 넘어가면 false 를 반환해주는 함수
     */
    fun getIsSizeSix(numbers: List<Int>): Boolean{
        return numbers.size == 6
    }

    /**
     * 1 ~ 45 이외의 숫자가 있으면 false 를 반환해주는 함수
     */
    fun getIsBetweenOneAndFortyFive(numbers: List<Int>):  Boolean{
        for (index in numbers.indices){
            if (numbers[index] !in 1..45)
                return false
        }
        return true
    }
}
