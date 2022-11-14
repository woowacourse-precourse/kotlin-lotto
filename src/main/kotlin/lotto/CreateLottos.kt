package lotto

//Lotto를 생성할 때 필요한 기능들이 들어가야함

class CreateLottos {

    companion object{

        // 1-1. 로또 수량 계산
        fun getLottoCount(lottoPrice : Int) : Int{
            val lottoCount = lottoPrice / 1000
            //만약 나누어지지 않을 시에 발생하는 예외 사항 처리 필요
            return lottoCount
        }
    }

}