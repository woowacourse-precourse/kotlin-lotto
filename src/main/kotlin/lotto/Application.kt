package lotto

fun main() {
    val price = InputNumbers.inputPrice()
    val lotto = LottoNumber()
    lotto.calculatePrice(price)


    val winning = InputNumbers.inputWinning()
    val winningNumber = WinningNumber()
    winningNumber.changeNumberList(winning)

    val bonusNumber = InputNumbers.inputBonus()

    val reward = Reward()
    reward.calculateSame(lotto.lottoNumber,winningNumber.winningNumber,bonusNumber)
    reward.calculateRevenue(reward.money, price)
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


//클래스 나누기
//보너스 점수 중복 증명하기
//45이상 숫자 예외처리
//하드코딩 하지않기
