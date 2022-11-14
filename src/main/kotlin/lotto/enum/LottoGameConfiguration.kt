package lotto.enum

enum class LottoGameConfiguration(val number: Int) {
    START_LOTTO_NUMBER(1),
    END_LOTTO_NUMBER(45),
    LOTTO_SIZE(6),
    LOTTO_PRICE(1_000)
}