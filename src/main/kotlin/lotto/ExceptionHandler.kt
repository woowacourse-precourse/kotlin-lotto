package lotto

object ExceptionHandler {

    /**
     *  입력한 로또 번호에 대해 조건에 따라 예외를 던져주는 함수
     */
    fun throwExceptionForLottoNumbers(lottoNumbers: List<Int>){
        when{
            !getHasDistinctNumber(lottoNumbers) -> throw IllegalArgumentException("[ERROR] 로또 번호는 서로 중복되지 않은 숫자여야 합니다.")
            !getIsSizeSix(lottoNumbers) -> throw IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.")
            !getIsBetweenOneAndFortyFive(lottoNumbers) -> throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }

    /**
     *  입력한 값이 숫자가 아니라면 false 를 반환해주는 함수
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
     *  입력한 로또 번호 중 중복된 숫자들이 있으면 false 를 반환해주는 함수
     */
    fun getHasDistinctNumber(lottoNumbers: List<Int>): Boolean{
        return lottoNumbers.size == lottoNumbers.distinct().size
    }

    /**
     *  입력한 로또 번호 중 숫자가 6개가 넘어가면 false 를 반환해주는 함수
     */
    fun getIsSizeSix(lottoNumbers: List<Int>): Boolean{
        return lottoNumbers.size == 6
    }

    /**
     * 입력한 로또 번호 중 1 ~ 45 이외의 숫자가 있으면 false 를 반환해주는 함수
     */
    fun getIsBetweenOneAndFortyFive(lottoNumbers: List<Int>):  Boolean{
        for (index in lottoNumbers.indices){
            if (lottoNumbers[index] !in 1..45)
                return false
        }
        return true
    }

    /**
     * 입력한 보너스 번호에 대해 조건에 따라 예외를 던져주는 함수
     */
    fun throwExceptionForBonusNumbers(bonusNumber: Int, lottoNumbers: List<Int>){
        when {
            !getIsBetweenOneAndFortyFive(bonusNumber) ->
                throw IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
            !getHasDistinctNumberInLottoNumbers(bonusNumber, lottoNumbers) ->
                throw IllegalArgumentException("[ERROR] 보너스 번호는 입력했던 6개의 숫자와 중복되지 않아야 합니다.")
        }
    }

    /**
     * 보너스 번호가 1과 45 사이가 아니라면 false 를 반환하는 함수
     */
    fun getIsBetweenOneAndFortyFive(bonusNumber: Int): Boolean{
        return bonusNumber in 1..45
    }

    /**
     * 보너스 번호가 입력한 6개의 로또 번호와 중복된다면 false 를 반환하는 함수
     */
    fun getHasDistinctNumberInLottoNumbers(bonusNumber: Int, lottoNumbers: List<Int>): Boolean{
        return !lottoNumbers.contains(bonusNumber)
    }

    /**
     * 입력한 구입 금액에 대해 조건에 따라 예외를 던져주는 함수
     */
    fun throwExceptionForPurchaseMoney(purchaseMoney: Int){
        when {
            !getIsThousandUnit(purchaseMoney) ->
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }

    /**
     * 구입 금액이 1000원 단위가 아니라면 false 를 반환하는 함수
     */
    fun getIsThousandUnit(purchaseMoney: Int): Boolean {
        return purchaseMoney.toDouble() % 1000.0 == 0.0
    }
}
