package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constants.LOTTO_MAX_NUMBER
import lotto.util.Constants.LOTTO_MIN_NUMBER
import lotto.util.Constants.WINNING_NUMBER_COUNT

class LottoPublisher(
    private val number: Int
) {

    var lottoContainer: ArrayList<Lotto> = arrayListOf()
        private set

    fun publishLotto() {
        repeat(number) {
            val lottoNumbers = Randoms
                .pickUniqueNumbersInRange(
                    LOTTO_MIN_NUMBER,
                    LOTTO_MAX_NUMBER,
                    WINNING_NUMBER_COUNT
                ).toList()
            lottoContainer.add(Lotto(lottoNumbers))
        }
    }
}