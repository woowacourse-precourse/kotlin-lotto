package lotto.domaintest.validatortest

import lotto.InputValidator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 100, 1500, 11500])
    fun `invalidate money check`(money:Int){
        assertFalse(InputValidator.validateMoney(money))
    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 5000, 100000])
    fun `validate money check`(money:Int){
        assertTrue(InputValidator.validateMoney(money))
    }
}
