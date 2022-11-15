package domain

class LottoNumberRepository {

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