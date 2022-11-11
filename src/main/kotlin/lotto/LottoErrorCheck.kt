package lotto

object LottoErrorCheck {

    fun checkallmoneyerror(money: String) {
        checkinputisnumber(money)
        checkleastvalue(money.toInt())
        checkitdoesnothavechange(money.toInt())
    }

    fun checkinputisnumber(input: String) {
        if (input.toIntOrNull() == null)
            throw IllegalArgumentException("[ERROR] 숫자를 입력해야합니다.")
    }

    fun checkleastvalue(money: Int) {
        if (money < 1000)
            throw IllegalArgumentException("[ERROR] 돈은 적어도 1000원 이상이어야합니다.")
    }

    fun checkitdoesnothavechange(money: Int) {
        if (money % 1000 != 0)
            throw IllegalArgumentException("[ERROR] 잔돈은 없어서 1000원 단위로 해야합니다.")
    }

    fun checklottoallerror(checklotto: List<Int>) {
        checklottosize(checklotto)
        checklottonumber(checklotto)
    }

    private fun checklottosize(checklotto: List<Int>) {
        if (checklotto.size != 6)
            throw IllegalArgumentException("[ERROR] 로또 번호는 6자리의 숫자여야 합니다.")
    }

    private fun checklottonumber(checklotto: List<Int>) {
        for (element in checklotto)
            checknumberisinlottorange(element)
    }

    fun checknumberisinlottorange(number: Int) {
        if (number < 1 || number > 45)
            throw IllegalArgumentException("[ERROR] 로또 번호는 1~45사이의 숫자여야 합니다.")
    }

}