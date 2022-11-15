package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun getLottoCountValue(price: Int): Int {
        return price / CONSTANT.PRICE.UNIT.params
    }
    fun createLottoNumber(count:Int): MutableList<Lotto> {
        val lottos = mutableListOf<Lotto>()
        var insertCount = 0
        while (insertCount < count){
            val lotto = getLottoNumber()
            if(lottos.contains(lotto))
                continue
            lottos.add(lotto)
            insertCount ++
        }
        return lottos
    }
    fun getLottoNumber(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(CONSTANT.LOTTO.MIN_LOTTO_NUMBER.params, CONSTANT.LOTTO.MAX_LOTTO_NUMBER.params, CONSTANT.LOTTO.LOTTO_COUNT.params)
        numbers.sort()
        return Lotto(numbers)
    }
    fun checkUserInputLotto(inputs:List<String>): Lotto {
        checkUserInputLottoInt(inputs)
        val inputToINT = mutableListOf<Int>()
        for (input in inputs)
            inputToINT.add(input.toInt())
        return Lotto(inputToINT)
    }
    private fun checkUserInputLottoInt(inputs:List<String>){
        try{
            for(input in inputs)
                input.toInt()
        }catch (e: IllegalArgumentException){
            println(CONSTANT.ERRORMESSAGE.LOTTONUMBERINTERROR.message)
            throw e
        }
    }
}