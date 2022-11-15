package lotto

class MatchLotto {
    fun countLottoNumber(lottoTicket : List<Int>, winningNumber : Lotto, bonusNumber: Int) : LottoRank {
        var countMatchNumber = 0

        for(number in winningNumber.getLottoNumbers()) {
            if(lottoTicket.contains(number)) countMatchNumber++
        }

        return when (countMatchNumber) {
            3 -> LottoRank.MATCH_THREE
            4 -> LottoRank.MATCH_FOUR
            5 -> isMatchBonusNumber(lottoTicket, bonusNumber)
            6 -> LottoRank.MATCH_SIX
            else -> LottoRank.MATCH_NONE
        }

    }

    private fun isMatchBonusNumber(lottoTicket: List<Int>, bonusNumber: Int) : LottoRank {
        return if(lottoTicket.contains(bonusNumber)) LottoRank.MATCH_FIVE_BONUS
        else LottoRank.MATCH_FIVE
    }


}