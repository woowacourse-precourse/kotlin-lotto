package lotto

class LottoWin {

    enum class LottoWinBall(var num: Int) {

        Ball1(0), Ball2(0), Ball3(0), Ball4(0), Ball5(0), Ball6(0), BonusBall(0)
    }

    fun winLotto() {
        inputWinLotto()
    }

    fun inputWinLotto(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val inputLottoWinNum = readLine()!!
        val inputLottoWinNumSplit = inputLottoWinNum.split(',')
        println(inputLottoWinNumSplit)
        inputLottoWinNumSplit.inputLottoNumberTypeException()
        val lottoWinNum = inputWinningNumberException(inputLottoWinNumSplit)
        for (i in 0 until LottoWinBall.values().size - 1) {
            LottoWinBall.values()[i].num = lottoWinNum[i]
        }
        return lottoWinNum
    }

    fun inputWinningNumberException(winningNumber: List<String>): List<Int> {
        try {
            Lotto(winningNumber.map { it.inputLottoNumberException() })
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("[ERROR] 당첨 번호의 개수가 잘못 입력되었거나 중복되었습니다.")
        }
        return winningNumber.map { it.inputLottoNumberException() }
    }

    fun List<String>.inputLottoNumberTypeException() {
        try {
            this.map {
                it.toInt()
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 당첨 번호를 잘못입력하셨습니다.")

        }
    }

    fun String.inputLottoNumberException(): Int {
        try {
            if (this.toInt() <= 0 || this.toInt() > 45) {
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
        return this.toInt()
    }


}