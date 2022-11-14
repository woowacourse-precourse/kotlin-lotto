package lotto

//Lotto를 생성할 때 필요한 기능들이 들어가야함

class CreateLottos {

    companion object{
        // 1. 로또 구입 금액 입력 받기
        fun getLottoPrice() : Int? {
            println("구입금액을 입력해 주세요.")
            val lottoPrice = readLine()?.toInt()
            //구입 금액 입력 받을 때 생길 수 있는 예외 사항 처리 필요
            return lottoPrice
        }

        // 1-1. 로또 수량 계산
        fun getLottoCount(lottoPrice : Int) : Int{
            val lottoCount = lottoPrice / 1000
            //만약 나누어지지 않을 시에 발생하는 예외 사항 처리 필요
            return lottoCount
        }
    }

}