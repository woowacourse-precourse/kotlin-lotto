package lotto

class Lotto(private val numbers: List<Int>) {

    // 생성자 초기화 블럭
    init {
        require(numbers.size == 6)
    }

    // 생성된 로또 출력 (오름차순)
    // [0,0,0,0,0,0]
    fun printLotto() {
        numbers.sorted() // 오름차순 정렬
        numbers.forEachIndexed { index, i ->
            if ( index == 0 ) print("[$i, ")
            if ( index > 0 && index < numbers.size-1) print("$i, ")
            if ( index == numbers.size-1 ) println("$i]")

        }
    }
}
