package domain

enum class Ranking(
    val rank:String,
    val price: Int,
    val count: Int
    ) {
    RANK3("3개 일치", 5000, 0),
    RANK4("4개 일치", 50000, 0),
    RANK5("5개 일치", 1500000, 0),
    RANKBonus5("5개 일치, 보너스 볼 일치", 30000000, 0),
    RANK6("6개 일치", 2000000000, 0);
}