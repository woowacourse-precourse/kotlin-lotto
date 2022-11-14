package lotto.domain

class LottoList(private val lottoList: List<Lotto>) {
    override fun toString(): String {
        val result = StringBuilder("")
        lottoList.forEach {
            result.append("${it}\n")
        }
        return result.toString()
    }
}