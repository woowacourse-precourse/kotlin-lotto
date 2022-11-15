package lotto

import camp.nextstep.edu.missionutils.Randoms

class CreateLottos {

    companion object{
        fun getLottoCount(lottoPrice : Int) : Int{
            LottoExecptions().getInputLottoPriceUnitException(lottoPrice)
            val lottoCount = lottoPrice / 1000
            return lottoCount
        }

        fun getLottoNums() : List<Int> {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            return numbers
        }

        fun getLottoNumsWithCount(lottoCount : Int) : List<List<Int>>{
            val lottoNums : MutableList<List<Int>> = ArrayList()
            for(i in 0..lottoCount){
                lottoNums.add(getLottoNums())
            }
            return lottoNums
        }

    }

}