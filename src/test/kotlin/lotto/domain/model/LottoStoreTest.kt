package lotto.domain.model

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("로또 구매 테스트")
class LottoStoreTest {

    private lateinit var lottoStore: LottoStore

    @BeforeEach
    fun setup() {
        lottoStore = LottoStore(CustomGenerator())
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 1",
        "20000, 20",
        "5000000, 5000"
    )
    @DisplayName("정확한 계수의 로또를 생성하는지 테스트한다.")
    fun generateLottosTest(input: String, expectedCount: Int) {
        val money = Money(input)
        assertSimpleTest {
            assertThat(LottoStore().purchaseLotto(money).size).isEqualTo(expectedCount)
        }
    }

    @Test
    @DisplayName("정확한 로또를 반환하는지 테스트한다.")
    fun generateLottoTest() {
        assertSimpleTest {
            val lottoNumbers =
                listOf(
                    LottoNumber.valueOf(1),
                    LottoNumber.valueOf(3),
                    LottoNumber.valueOf(5),
                    LottoNumber.valueOf(6),
                    LottoNumber.valueOf(7),
                    LottoNumber.valueOf(8)
                )
            assertThat(lottoStore.generateLotto())
                .containsAll(lottoNumbers)
        }
    }

    @Test
    @DisplayName("정확한 로또 타입을 리턴하는지 테스트한다.")
    fun generateLottoTypeTest() {
        assertSimpleTest {
            LottoStore().purchaseLotto(Money("10000")).forEach {
                assertThat(it).isInstanceOf(Lotto::class.java)
            }
        }
    }

    inner class CustomGenerator : GenerateLottoNumber {
        override fun generate(): List<Int> {
            return listOf(1, 3, 5, 6, 7, 8)
        }
    }
}