package use_case

import exception.LottoException
import kotlin.system.exitProcess

class GetCorrectLotto {
    private var correctLotto = mutableListOf<Int>()
    private var bonus = 0

    init {
        try {
            getAnswerLotto()
            getBonusLotto()
        } catch(e: IllegalArgumentException){
            println("[ERROR] 당첨 로또값 입력 오류")
            exitProcess(-1)
        }
    }

    fun getCorrectValue(): List<Int> {
        return correctLotto
    }

    fun getBonusValue(): Int{
        return bonus
    }
    private fun getAnswerLotto() {
        println("당첨 번호를 입력해주세요.")
        correctLotto = readLine()
            ?.split(',')
            ?.map { it.toInt() }
            ?.toMutableList() ?: throw IllegalArgumentException()
        LottoException().correctException(correctLotto)
        println()
    }

    private fun getBonusLotto() {
        println("보너스 번호를 입력해주세요.")
        bonus = readLine()?.toInt() ?: throw IllegalArgumentException()
        LottoException().bonusException(correctLotto, bonus)
        println()
    }
}