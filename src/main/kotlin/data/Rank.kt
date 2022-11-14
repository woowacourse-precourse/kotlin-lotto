package data

enum class Rank(val reward: Int) {
    LAST(NONE),
    FIFTH(FIVE_THOUS),
    FOURTH(FIFTY_THOUS),
    THIRD(ONE_MILLI_FIVE_HUND_THOUS),
    SECOND(THIRTY_MILLI),
    FIRST(TWO_BILLI)
}