package lotto.domain

/**
 * 클래스는 프로퍼티, init 블록, 부 생성자, 메서드, 동반 객체 순으로
 */
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6자리여야 합니다." }
    }

    // 구입 금액에 해당하는 만큼 로또 번호를 뽑는다.
    fun createLottoNumber(): List<Int> {
        return emptyList()
    }

    // 당첨 번호를 뽑는다.
    fun createWinningNumber(): List<Int> {
        return emptyList()
    }

    // 보너스 번호를 뽑는다.
    fun createBonusNumber(): Int {
        return 0
    }
}
