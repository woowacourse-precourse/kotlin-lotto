package lotto

fun main() {
    playLotto()
}

fun playLotto(){
    val price = checkPriceNumber()

    val lottoNumber = LottoNumber(price)
    lottoNumber.calculatePrice()

    val winning = InputNumbers.inputWinning()
    val winningNumber = WinningNumber()
    winningNumber.changeNumberList(winning)

    val bonusNumber = checkBonusNumber()
    winningNumber.checkBonus(bonusNumber)
    val reward = Reward()
    reward.calculateSame(lottoNumber.lottoNumber,winningNumber.winningNumber,bonusNumber)
    reward.calculateRevenue(reward.money, price)
}

fun checkPriceNumber(): Int {
    var price = 0
    try{
        price = InputNumbers.inputPrice()
    }catch (e: IllegalArgumentException){
        print("[ERROR] 입력값은 숫자로 이루어져야 합니다.")
    }
    return price
}

fun checkBonusNumber(): Int {
    var bonusNumber = 0
    try{
        bonusNumber = InputNumbers.inputBonus()
    }catch (e: IllegalArgumentException){
        print("[ERROR] 입력값은 숫자로 이루어져야 합니다.")
    }
    return bonusNumber
}



enum class Message {
    PRICE, COUNT, NUMBER, BONUS,
}

fun getMessage(message: Message) {
    when (message) {
        Message.PRICE -> println("구입금액을 입력해 주세요.")
        Message.COUNT -> println("개를 구매했습니다.")
        Message.NUMBER -> println("당첨 번호를 입력해 주세요.")
        Message.BONUS -> println("보너스 번호를 입력해 주세요.")
    }
}
