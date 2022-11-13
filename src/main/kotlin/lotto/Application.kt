package lotto

/* import lotto.LottoGame */

fun main() {
    LottoGame().buyPriceInquireMessage()
    val inputPrice = LottoGame().inputNum()
    val flagRightLotto = LottoGame().checkRightLotto(inputPrice)
    val numberOfLotto = LottoGame().calculateNumberOfLotto(inputPrice)
    LottoGame().resultRightLotto(flagRightLotto)
    LottoGame().tellNumOfLotto(numberOfLotto)
    val lottos = LottoGame().generateRandomLottos(numberOfLotto)
    LottoGame().printEachLotto(lottos)

    // 정답 로또 번호 받기
    LottoGame().answerNumbersMessage()
    val answerNumbers= LottoGame().inputAnswerNumbers()
    Lotto(answerNumbers).checkinputAnswer()

    // 보너스 번호 받기
    LottoGame().bonusNumberMessage()
    val inputBonusPrice = LottoGame().inputNum().toString()
    LottoGame().checkinputBonus(inputBonusPrice)
    
    // 통계 결과 내기
    LottoGame().printStats()


}