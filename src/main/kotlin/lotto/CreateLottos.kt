package lotto

import camp.nextstep.edu.missionutils.Randoms

//Lotto를 생성할 때 필요한 기능들이 들어가야함

class CreateLottos {

    companion object{
        // 1-1. 로또 수량 계산
        fun getLottoCount(lottoPrice : Int) : Int{
            val lottoCount = lottoPrice / 1000
            //만약 나누어지지 않을 시에 발생하는 예외 사항 처리 필요
            return lottoCount
        }

        //4. 1~45까지의 숫자 중 중복되지 않는 6개의 숫자를 뽑는다
        fun getLottoNums() : List<Int> {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
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