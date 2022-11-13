package lotto

enum class LottoPrice(val catchCount:Int, val price:Int) {
    NONE(-1, 0),
    FIFTH_PLACE(3, FIFTH_PLACE_PRICE),
    FOURTH_PLACE(4, FOURTH_PLACE_PRICE),
    THIRD_PLACE(5, THIRD_PLACE_PRICE),
    SECOND_PLACE(5, SECOND_PLACE_PRICE),
    FIRST_PLACE(6, FIRST_PLACE_PRICE)
}