package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        LottoError.checkLottoNum(numbers)
    }

    // TODO: 추가 기능 구현
}
