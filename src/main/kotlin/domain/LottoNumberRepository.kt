package domain

class LottoNumberRepository {
    private val ERROR_MESSAGE_LOTTO_NUMBER = "[ERROR] 로또 번호 추첨 개수는 6개여야 합니다."

    // 생성한 로또 저장소
    fun lottoNumberRepository(lottoNumber: Long): Set<List<Int>>{
        val lottoRepository = mutableSetOf<List<Int>>()
        while (lottoRepository.size < lottoNumber){
            val createLottoNumber = CreateLottoNumber()
            val createLotto = createLottoNumber.createRandomLottoNumber()
            lottoRepository.add(createLotto)

        }

        return lottoRepository
    }

}