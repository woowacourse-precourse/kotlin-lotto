package data

enum class WinningAmount(val amount: Int, val keyName: String, val resource: String) {
    FIRST(2_000_000_000, "6", "6개 일치 (2,000,000,000원) - _개"),
    SECOND(30_000_000, "5_1", "5개 일치, 보너스 볼 일치 (30,000,000원) - _개"),
    THIRD(1_500_000, "5_0", "5개 일치 (1,500,000원) - _개"),
    FOURTH(50_000, "4", "4개 일치 (50,000원) - _개"),
    FIFTH(5_000, "3", "3개 일치 (5,000원) - _개");

}
