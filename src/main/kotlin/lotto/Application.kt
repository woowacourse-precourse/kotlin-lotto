package lotto

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

fun main() {
    try {
        val lottoPrice = Console.readLine()
        val lottoGenerator = LottoGenerator()
        lottoGenerator.createLottoNumber(lottoPrice)
    }catch(e:IllegalArgumentException){
    }
}
