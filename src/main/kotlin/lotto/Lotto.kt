package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTERY_SIZE) {
            "$TAG 로또 번호는 ${LOTTERY_SIZE}개여야 합니다."
        }
        val checkedList = mutableListOf<Int>()
        for(i in numbers) {
            if(!NUMBER_RANGE.contains(i)) throw IllegalArgumentException("$TAG 로또 번호는 ${NUMBER_RANGE.first}부터 ${NUMBER_RANGE.last} 사이의 숫자여야 합니다.")
            if(checkedList.contains(i)) throw IllegalArgumentException("$TAG 로또 번호는 서로 다른 숫자로 구성되어야 합니다.")
            checkedList.add(i)
        }
    }

    // TODO: 추가 기능 구현
}
