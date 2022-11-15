package lotto

enum class State(val message: String) {
    start("구입금액을 입력해 주세요."),
    many("개를 구매했습니다."),
    enterLottoNumber("당첨 번호를 입력해 주세요."),
    enterBonusNumber("보너스 번호를 입력해 주세요."),
    end("당첨 통계");
}


enum class Prize(val message: String) {
    three("3개 일치 (5,000원) - "),
    four("4개 일치 (50,000원) - "),
    five("5개 일치 (1,500,000원) - "),
    fiveBonus("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    six("6개 일치 (2,000,000,000원) - "),
    profit1("총 수익률은"),
    profit2("%입니다.")
}

enum class error(val message: String) {
    inputSomething("[ERROR] 아무것도 입력하지 않으셨습니다"), //아무것도 입력하지 않으셨습니다
    wrongInput("[ERROR] 잘못 입력하셨습니다"), //잘못 입력하셨습니다
    onlyNumberInput("[ERROR] 숫자만 입력해야 합니다"), //숫자만 입력해야 합니다
    sameNumberInLotto("[ERROR] 중복된 번호가 있습니다"), //중복된 번호가 있습니다
    sameNumberInBonus("[ERROR] 로또 번호와 겹칩니다"), //로또 번호와 겹칩니다
    wrongNumber("[ERROR] 보너스 번호는 1~45 사이"); //보너스 번호는 1~45 사이

}