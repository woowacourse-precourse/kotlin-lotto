package lotto

fun main() {
    view.View().buyPriceInquireMessage() // 구매 로또 금액 받기
    val inputPrice = LottoGame().inputNum()
    if (inputPrice == -1) { return }
    val numberOfLotto = Controller().getLottoPrice(inputPrice)

    val lottos = LottoGame().generateRandomLottos(numberOfLotto) // 생성된 로또들 print해서 보여주기
    view.View().printEachLotto(lottos)

    val answerNumbers = Controller().answerLottoNum() // 정답 로또 번호 받기

    val inputBonusPrice = Controller().bonusLottoNum(answerNumbers) // 보너스 번호 받기

    Controller().winLotto(lottos, answerNumbers, inputBonusPrice, inputPrice) // 통계 결과 내기
}