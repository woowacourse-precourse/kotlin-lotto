package lotto.error

import lotto.data.Lotto

object ErrorMessages {

    private const val PREFIX = "[ERROR]"

    private fun String.applyPrefix(): String = "$PREFIX $this"

    enum class LottoEnum(private val message: String) {

        RequiredSixLength("${Lotto.LENGTH}개의 숫자를 입력해주세요."),
        NotDuplicated("중복된 숫자가 있으면 안됩니다."),
        OutOfRangeNumbers("${Lotto.Range} 범위 내의 숫자여야 합니다."),;

        override fun toString(): String = message.applyPrefix()
    }
}
