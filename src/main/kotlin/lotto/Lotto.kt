package lotto

class Lotto(private val numbers: List<Int>) {

    // 생성자 초기화 블럭
    init {
        require(numbers.size == 6)
    }

    // 생성된 로또 출력
    // [0,0,0,0,0,0]
    fun printLotto() {
        numbers.forEachIndexed { index, i ->
            if ( index == 0 ) print("[$i, ")
            if ( index > 0 && index < numbers.size-1) print("$i, ")
            if ( index == numbers.size-1 ) println("$i]")
        }
    }

    // 결과 출력
    fun generateResult(winLottoNumber:List<Int>, bonusNumber: Int): LottoWinningPlace {
        // 해당 로또에 당첨 번호가 몇 개나 있는지 판별
        val correctNumber = numbers.count { winLottoNumber.contains(it) }
        // 1등 (6개)
        if ( correctNumber == 6 ) return LottoWinningPlace.FIRST

        // 2등, 3등 (5개)
        if ( correctNumber == 5 ) {
            // 2등: 해당 로또가 보너스 번호를 가지고 있는지
            if ( numbers.contains(bonusNumber) ) return LottoWinningPlace.SECOND
            return LottoWinningPlace.THIRD
        }

        // 4등 (4개)
        if ( correctNumber == 4 ) return LottoWinningPlace.FOURTH

        // 5등 (3개)
        if ( correctNumber == 3 ) return LottoWinningPlace.FIFTH

        // 탈락
        return LottoWinningPlace.NOTHING
    }
}
