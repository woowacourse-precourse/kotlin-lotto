package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ConsumerTest {
    lateinit var consumer : Consumer

    @BeforeEach
    fun setUp(){
        consumer = Consumer(8000)
    }

    @Test
    fun `1등 테스트`(){
        consumer.myLotto.clear()
        consumer.myLotto.add(mutableListOf(8, 21, 23, 41, 42, 47))
        val result = consumer.compareLotto(Lotto(mutableListOf(8, 21, 23, 41, 42, 47)),7)
        Assertions.assertThat(result[0]).isEqualTo(1)
    }

    @Test
    fun `2등 테스트`(){
        consumer.myLotto.clear()
        consumer.myLotto.add(mutableListOf(8, 21, 23, 41, 42, 43))
        val result = consumer.compareLotto(Lotto(mutableListOf(8, 21, 23, 41, 42, 47)),43)
        Assertions.assertThat(result[1]).isEqualTo(1)
    }

    @Test
    fun `3등 테스트`(){
        consumer.myLotto.clear()
        consumer.myLotto.add(mutableListOf(1, 2, 3, 4, 5, 6))
        val result = consumer.compareLotto(Lotto(mutableListOf(1, 2, 3, 4, 5, 7)),42)
        Assertions.assertThat(result[2]).isEqualTo(1)
    }

    @Test
    fun `4등 테스트`(){
        consumer.myLotto.clear()
        consumer.myLotto.add(mutableListOf(1, 2, 3, 4, 5, 6))
        val result = consumer.compareLotto(Lotto(mutableListOf(1, 2, 3, 4, 8, 7)),42)
        Assertions.assertThat(result[3]).isEqualTo(1)
    }

    @Test
    fun `5등 테스트`(){
        consumer.myLotto.clear()
        consumer.myLotto.add(mutableListOf(1, 2, 3, 4, 5, 6))
        val result = consumer.compareLotto(Lotto(mutableListOf(1, 2, 3, 9, 8, 7)),42)
        Assertions.assertThat(result[4]).isEqualTo(1)
    }

    @Test
    fun  `수익률 테스트`(){
        consumer.myLotto.clear()
        val result = consumer.calculateYield(mutableListOf(0,0,0,0,1))
        Assertions.assertThat(result).isEqualTo("62.5")
    }
}