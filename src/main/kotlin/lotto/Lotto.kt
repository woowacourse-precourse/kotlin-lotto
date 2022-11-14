package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        for (number in 0..5){
            if (numbers[number] !in 1..45){
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        }
    }

    // TODO: 추가 기능 구현
}
