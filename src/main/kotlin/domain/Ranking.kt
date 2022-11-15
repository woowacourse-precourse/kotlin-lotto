package domain

enum class Ranking(
    val rank:String,
    val price: Int
    ) {
    RANK3("3개 일치 (5,000원)", 5000 ),
    RANK4("4개 일치 (50,000원)", 50000 ),
    RANK5("5개 일치 (1,500,000원)", 1500000 ),
    RANKBonus5("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000 ),
    RANK6("6개 일치 (2,000,000,000원)", 2000000000 );
}
