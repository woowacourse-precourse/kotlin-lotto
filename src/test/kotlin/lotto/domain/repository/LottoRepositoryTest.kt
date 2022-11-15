package lotto.domain.repository

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import lotto.domain.model.Lotto
import lotto.domain.model.Rank
import lotto.domain.model.WinningLottery
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("LottoRepository 클래스 단위 테스트")
internal class LottoRepositoryTest {

    private lateinit var lottoRepository: LottoRepository
    private lateinit var winningLottery: WinningLottery

    @BeforeEach
    fun setUp() {
        lottoRepository = LottoRepository()
        winningLottery = WinningLottery("1,2,3,4,5,6", "7")
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 1",
        "20000, 20",
        "5000000, 5000"
    )
    @DisplayName("정확한 계수의 로또를 생성하는지 테스트한다.")
    fun generateLottosTest(input: Long, expectedCount: Int) {
        assertSimpleTest {
            assertThat(lottoRepository.generateLottos(input).size).isEqualTo(expectedCount)
        }
    }

    @Test
    @DisplayName("정확한 로또 타입을 리턴하는지 테스트한다.")
    fun generateLottoTypeTest() {
        assertSimpleTest {
            lottoRepository.generateLottos(10000).forEach {
                assertThat(it).isInstanceOf(Lotto::class.java)
            }
        }
    }


    @Test
    @DisplayName("1등(6개), 2등(5개), 2등 + 보너스 번호 결과를 리턴하는지 테스트한다.")
    fun lottoResultTest() {
        assertSimpleTest {
            val lottoList = listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 2, 3, 4, 5, 10)),
                Lotto(listOf(1, 2, 3, 4, 5, 7)),
            )
            assertThat(lottoRepository.calStatistics(winningLottery, lottoList)).containsAll(
                listOf(
                    Rank.CORRECT_SIX,
                    Rank.CORRECT_FIVE,
                    Rank.CORRECT_FIVE_BONUS
                )
            )
        }
    }


    @Test
    @DisplayName("3등(4개), 4등(3개) 결과를 리턴하는지 테스트한다.")
    fun lottoResultTest2() {
        assertSimpleTest {
            val lottoList = listOf(
                Lotto(listOf(4, 5, 6, 10, 11, 15)),
                Lotto(listOf(1, 2, 3, 4, 10, 15)),
                Lotto(listOf(1, 2, 3, 10, 13, 15)),
            )
            assertThat(lottoRepository.calStatistics(winningLottery, lottoList))
                .containsAll(listOf(Rank.CORRECT_THREE, Rank.CORRECT_FOUR))
        }
    }

    @Test
    @DisplayName("꼴등 결과를 리턴하는지 테스트한다.")
    fun lottoResultTest3() {
        assertSimpleTest {
            val lottoList = listOf(
                Lotto(listOf(10, 15, 16, 20, 21, 25)),
                Lotto(listOf(11, 12, 13, 14, 20, 25)),
            )
            assertThat(lottoRepository.calStatistics(winningLottery, lottoList))
                .contains(Rank.CORRECT_ZERO)
        }
    }
}