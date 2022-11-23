package lotto.domain

import lotto.enums.Rating

object View {
    private const val INPUT_PURCHASING_AMOUNT = "구입금액을 입력해 주세요."
    private const val INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

    /**
     * 구입 금액 입력 메시지를 출력하는 함수
     * */
    fun showInputPurchasingAmount() {
        println(INPUT_PURCHASING_AMOUNT)
    }

    /**
     * 당첨 번호 입력 메시지를 출력하는 함수
     * */
    fun showInputWinningNumber() {
        println(INPUT_WINNING_NUMBERS)
    }

    /**
     * 보너스 번호 입력 메시지를 출력하는 함수
     * */
    fun showInputBonusNumber() {
        println(INPUT_BONUS_NUMBER)
    }

    /**
     * 구매한 로또 장 수를 출력하는 함수
     * */
    fun showCountOfLotto(countOfLotto: Int) {
        println("${countOfLotto}개를 구매했습니다.")
    }

    /**
     * 구매한 로또 번호들을 출력하는 함수
     * */
    fun showPurchasedLottoNumbers(lottoNumbers: MutableList<Lotto>) {
        for (lottoNumber in lottoNumbers) {
            println(lottoNumber.toString())
        }
    }

    /**
     * 당첨 통계를 출력하는 함수
     * */
    fun showResultOfLotto(resultOfLotto: MutableList<Rating>, countOfLotto: Int) {
        val domainService = DomainService()
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${domainService.countRank(resultOfLotto, Rating.FIFTH)}개")
        println("4개 일치 (50,000원) - ${domainService.countRank(resultOfLotto, Rating.FOURTH)}개")
        println("5개 일치 (1,500,000원) - ${domainService.countRank(resultOfLotto, Rating.THIRD)}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${domainService.countRank(resultOfLotto, Rating.SECOND)}개")
        println("6개 일치 (2,000,000,000원) - ${domainService.countRank(resultOfLotto, Rating.FIRST)}개")
        println("총 수익률은 ${domainService.calculateIncome(resultOfLotto, countOfLotto)}%입니다.")
    }
}