package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
	init {
		require(numbers.size == 6)
	}

	// TODO: 추가 기능 구현
	fun getNumbers(): List<Int> {
		return numbers
	}
}
