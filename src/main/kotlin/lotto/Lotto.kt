package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        LottoCheckError(numbers).checkLottoThrowException()
    }

    // TODO: 추가 기능 구현
}
