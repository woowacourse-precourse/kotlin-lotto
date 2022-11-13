package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.Constant
import lotto.constants.Exception
import lotto.views.InputView
import lotto.views.OutputView

class Purchase {
    init {
        OutputView.printInputMoney()
    }

    fun buyLotto(): Int {
        val money = InputView.inputMoney()
        validateMoney(money)
        return money / Constant.MONEY_UNIT
    }

    fun validateMoney(money: Int) {
        if (money % Constant.MONEY_UNIT != 0) {
            throw IllegalArgumentException(Exception.EXCEPTION_INVALID_MONEY)
        }
    }

    // 구매 수량 만큼의 로또를 생성하여 리스트로 반환하는 메소드
    fun createLottos(amount: Int): LottoWrapper {
        val lottos = LottoWrapper()
        for (i in Constant.START_INDEX until amount) {
            val lotto = Lotto(createLottoNumber().sorted())
            lottos.add(lotto)
        }
        return lottos
    }

    private fun createLottoNumber(): MutableList<Int> {
        val numbers = mutableListOf<Int>()
        while (numbers.size < 6) {
            var randomNumber = Randoms.pickNumberInRange(1, 45)
            addLottoNumber(randomNumber, numbers)
        }
        return numbers
    }

    // 뽑은 랜덤 숫자의 중복 여부를 확인하고 아닐 시 리스트에 추가하는 메소드
    private fun addLottoNumber(randomNumber: Int, numbers: MutableList<Int>) {
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber)
        }
    }
}