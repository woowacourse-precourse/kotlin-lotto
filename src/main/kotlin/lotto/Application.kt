package lotto

fun main() {
    val price = Controller.getMoney()

    val lottoLog = Controller.purchaseLotto(price)

    val lottoNumber = Controller.getLottoNumber()

    val bonusNumber = Controller.getBonusNumber(lottoNumber)

    val result = Controller.getResult(lottoLog, lottoNumber, bonusNumber)

    Controller.getRatio(price, result)
}