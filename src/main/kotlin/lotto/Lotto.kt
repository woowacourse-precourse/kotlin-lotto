package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            isNotSixNumbers()
        }
        require(numbers.distinct().size == 6) {
            isOverlap()
        }
        isNotLottoNumber()
    }

    private fun isNotSixNumbers() {
        if(numbers.size != 6)
            throw IllegalArgumentException("[ERROR] 로또 번호가 6개가 아닙니다.")
    }

    private fun isOverlap() {
        if(numbers.size != numbers.distinct().size)
            throw IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.")
    }

    private fun isNotLottoNumber() {
        for(lottoNumber in numbers ) {
            if( lottoNumber.toInt() < 1 || lottoNumber.toInt() > 45 ) {
                throw IllegalArgumentException("[ERROR] 입력한 로또 번호 ${lottoNumber}는 존재하지 않습니다.")
            }
        }
    }
}
