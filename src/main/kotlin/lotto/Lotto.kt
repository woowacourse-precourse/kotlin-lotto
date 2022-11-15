package lotto

class Lotto(private val numbers: List<Int>) {   //입력받은 숫자가 형식에 맞는지 확인하는 코드
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.distinct() == numbers) { "[ERROR] 로또 번호는 중복되는 숫자가 없어야 합니다." }
        for (number in numbers) {
            require(number in 1..45) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." }
        }
    }

}
