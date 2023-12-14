package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.model.Lotto
import lotto.util.Form
import lotto.util.Rule
import lotto.validation.LottoValidation

class LottoManager(
    private val lottoVerifier: LottoValidation,
    private val lottoCount: Int
) {
    private var lottoBundle = mutableListOf<Lotto>()

    fun purchaseLotto(){
        repeat(lottoCount){
            makeOneLotto()
        }
    }

    fun makeOutputValues(): List<String>{
        return lottoBundle.map {
            it.convertOutputValue()
        }
    }

    private fun makeOneLotto(){
        try{
            val newNumbers = Randoms.pickUniqueNumbersInRange(
                Rule.MIN_LOTTO_NUM, Rule.MAX_LOTTO_NUM, Rule.LOTTO_COUNT
            )
            lottoVerifier.checkAccuracyLottoNumbers(convertVerificationValue(newNumbers))
            lottoBundle.add(Lotto(newNumbers))
        } catch (e : IllegalArgumentException){
            e.message
        }
    }

    private fun convertVerificationValue(numbers: List<Int>) = numbers.joinToString(Form.LOTTO_SEPARATOR)

}