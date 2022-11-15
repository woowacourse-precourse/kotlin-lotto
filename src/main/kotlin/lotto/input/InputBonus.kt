package lotto.input

class InputBonus(private val lottoNumber: String) {
    private val userInputNumber= lotto.util.input().inputUser()
    fun inputBonusNumber(): Int {
        print("보너스 번호를 입력해 주세요.")
        checkBonusStandard(userInputNumber, lottoNumber)
        println(userInputNumber.toInt())
        return userInputNumber.toInt()
    }
    fun checkBonusStandard(userInputNumber: String?, lottoNumbers: String) {
        userInputNumber ?: throw IllegalArgumentException()
        val lottoOverlapCheck = mutableListOf<String>()
        val lottoNumber =lottoNumbers.split(",")
        if (userInputNumber.toInt() >= 46 || userInputNumber.toInt() < 1) throw IllegalArgumentException()
        lottoOverlapCheck.add(userInputNumber)
        lotto.util.InputValidable().checkInputMessagePatten(lottoOverlapCheck)
        if (lottoOverlapCheck.size != 1 ||lottoNumber.contains(lottoOverlapCheck[0])){
            println("[ERROR]")
            throw IllegalArgumentException()
        }
    }
}