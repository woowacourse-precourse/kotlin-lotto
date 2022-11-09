package lotto

import org.junit.jupiter.api.assertThrows

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        var numbers = numbers
    }

    fun Find_Error(){
        if (numbers.size != 6) assertThrows<IllegalArgumentException>{"[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."}
    }

    fun Find_Duplicate(){
        if (numbers.size != numbers.distinct().size) assertThrows<IllegalArgumentException>{"[ERROR] 중복된 숫자입니다."}
    }
}
