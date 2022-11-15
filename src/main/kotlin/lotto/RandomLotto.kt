package lotto

import camp.nextstep.edu.missionutils.Randoms

class RandomLotto {
    fun randomLottoNum(count : Int) : List<Lotto> {
        val lottoResult = mutableListOf<Lotto>()
        for(i in 0 until count){
            val lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottoResult.add(Lotto(lottoNumbers))
        }
        return lottoResult
    }
}