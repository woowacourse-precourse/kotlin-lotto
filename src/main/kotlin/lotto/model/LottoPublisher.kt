package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.LottoData.lottos
import lotto.model.LottoData.lottosLotto
import lotto.util.Constants.LOTTO_MAX_NUMBER
import lotto.util.Constants.LOTTO_MIN_NUMBER
import lotto.util.Constants.WINNING_NUMBER_COUNT

class LottoPublisher(
    private val number: Int
) {
    init {
        publishLotto()
    }

    private fun publishLotto() {
        repeat(number) {
            val lottoNumbers = Randoms
                .pickUniqueNumbersInRange(
                    LOTTO_MIN_NUMBER,
                    LOTTO_MAX_NUMBER,
                    WINNING_NUMBER_COUNT
                ).toList()
            lottos.add(lottoNumbers.sorted())
            lottosLotto.add(Lotto(lottoNumbers.sorted()))
        }
    }

}