package lotto.domain.model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

@DisplayName("Money클래스 테스트")
internal class MoneyTest {

    @DisplayName("숫자가 아닌 값이 입력됬을 때 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1000O", " ", "", "!@"])
    fun numberTest(number: String) {
        assertThrows(IllegalArgumentException::class.java) {
            Money(number)
        }
    }

    @DisplayName("1,000단위가 아닌 값이 입력됬을 때 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = ["2001", "1002", "110", "20005"])
    fun moneyUnitTest(number: String) {
        assertThrows(IllegalArgumentException::class.java) {
            Money(number)
        }
    }

}