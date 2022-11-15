package lotto

class Enum {
	enum class UserInputWord(val order: String) {
		BUY_PRICE("구입금액"),
		WINNING_NUMBER("당첨 번호"),
		BONUS_NUMBER("보너스 번호"),
		PLEASE_ENTER(" 입력해 주세요.")
	}

	enum class Error(val words: String) {
		INVALID_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
		INAPPROPRIATE_ORDER("[ERROR] inappropriate order"),
	}

	enum class Price(val value: Long) {
		LONG_ZERO(0L),
		UNIT(1000)
	}

	enum class LottoNumber(val value: Int) {
		MIN(1),
		MAX(45),
		QUANTITY(6)
	}

	enum class Strings(val value: String) {
		NUMBERS_WITH_COMMA_REGEX("^[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2},[0-9]{1,2}\$"),
		ONLY_NUMBER_REGEX("^[0-9]{1,2}\$"),
		POSTPOSITION_TYPE1("을"),
		POSTPOSITION_TYPE2("를")
	}

	enum class Index(val value: Int) {
		WINNING_NUMBERS(0),
		BONUS_NUMBER(1),
		WINNING_COUNT_ZERO(0),
		WINNING_COUNT_FOUR(4),
		WINNING_COUNT_MEDIATOR(3),
		WINNING_COUNT_SECOND(3),
		WINNING_COUNT_FIRST(4)
	}

	enum class Bonus(val value: Int) {
		INDEX(0),
		HAVE_TO_CHECK(5),
		NO(5),
		YES(7)
	}

	enum class Rank(val value: Int) {
		MIN(3),
		MAX(7),
		INIT(0),
		COUNT(1),
		FIFTH(5_000),
		FOURTH(50_000),
		THIRD(1_500_000),
		SECOND(30_000_000),
		FIRST(2_000_000_000)
	}

	enum class Print(val words: String) {
		QUANTITY("개를 구매했습니다."),
		RATE("당첨 통계\n---"),
		UNIT("개"),
		TOTAL("총 수익률은 "),
		IS_PERCENT("%입니다."),
		CORRECT_THREE("3개 일치 (5,000원) - "),
		CORRECT_FOUR("4개 일치 (50,000원) - "),
		CORRECT_FIVE("5개 일치 (1,500,000원) - "),
		CORRECT_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
		CORRECT_SIX("6개 일치 (2,000,000,000원) - ")
	}
}