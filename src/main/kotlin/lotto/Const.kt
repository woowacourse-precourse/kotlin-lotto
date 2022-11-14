package lotto

import java.text.DecimalFormat

const val MINIMUM_LOTTO_NUMBER = 1
const val MAXIMUM_LOTTO_NUMBER = 45

const val SIZE_OF_LOTTO_NUMBERS = 6
const val LOTTO_PRICE = 1000

const val REQUEST_MONEY = "구입금액을 입력해 주세요."
const val PURCHASED_LOTTO_COUNT = "%d개를 구매했습니다."
const val REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
const val REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

const val FIFTH_PLACE_PRICE = 5000
const val FOURTH_PLACE_PRICE = 50000
const val THIRD_PLACE_PRICE = 1500000
const val SECOND_PLACE_PRICE = 30000000
const val FIRST_PLACE_PRICE = 2000000000

const val PLACE_MSG="%d개 일치 (%s원) - %d개"
const val SECOND_PLACE_MSG="%d개 일치, 보너스 볼 일치 (%s원) - %d개"

const val ERROR_MSG_INPUT_MONEY= "[ERROR] 돈은 1000원 단위로 입력할 수 있습니다."
const val ERROR_MSG_NUMERIC = "[ERROR] 숫자가 아닌 입력이 포함되어 있습니다."
const val ERROR_MSG_RANGE = "[ERROR] 로또 번호는 1과 45사이의 숫자로 이루어져야합니다."
const val ERROR_MSG_OVERLAPPED = "[ERROR] 하나의 로또 안에 중복된 숫자는 존재할 수 없습니다."
const val ERROR_MSG_OVER_SIZE="[ERROR] 보너스 번호를 제외한 로또 번호는 6개의 숫자로 이루어져 있습니다."

const val PROFIT_RESULT = "총 수익률은 %.1f%%입니다."
