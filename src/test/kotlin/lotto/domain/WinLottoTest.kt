package lotto.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WinLottoTest {
    @Test
    fun `당첨 결과 map 반환 테스트`() {
        val winLotto = WinLotto()
        var lottos = arrayListOf<List<Int>>()
        //1등
        lottos.add(listOf(1,2,3,4,5,6))
        //2등
        lottos.add(listOf(1,2,3,4,5,45))
        //3등
        lottos.add(listOf(1,2,3,4,5,7))
        //4등
        lottos.add(listOf(1,2,3,4,7,8))
        //5등
        lottos.add(listOf(1,2,3,7,8,9))

        val winningNumber = listOf(1,2,3,4,5,6)
        val bonusNumber = 45

        val rankResult = mutableMapOf<Rank, Int>()
        for(i in Rank.values()){
            rankResult[i] = 1
        }

        Assertions.assertEquals(winLotto.getRankResult(lottos, winningNumber, bonusNumber),rankResult)
    }
}