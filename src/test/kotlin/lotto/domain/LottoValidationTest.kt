package lotto.domain

import lotto.util.Form
import lotto.validation.LottoValidation
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoValidationTest {

    private val lottoValidation = LottoValidation()

    @Test
    fun `올바른 로또 넘버 생성 테스트`(){
        lottoValidation.checkAccuracyLottoNumbers("1,2,3,4,5,6")
    }

    @Test
    fun `올바른 보너스 넘버 생성 테스트`(){
        lottoValidation.checkAccuracyBonusNumber("7",setOf(1,2,3,4,5,6))
    }

    @Test
    fun `로또 번호가 너무 적은 경우 예외 테스트`(){
        assertThrows<IllegalArgumentException> {
            lottoValidation.checkAccuracyLottoNumbers("1,2,3,4")
        }
    }

    @Test
    fun `로또 번호가 너무 많은 경우 예외 테스트`(){
        assertThrows<IllegalArgumentException> {
            lottoValidation.checkAccuracyLottoNumbers("1,2,3,4,5,6,7")
        }
    }

    @Test
    fun `정확하지 않은 로또 번호가 존재하는 경우 예외 테스트`(){
        assertThrows<IllegalArgumentException> {
            lottoValidation.checkAccuracyLottoNumbers("1,2,3,4,5,육")
        }
    }

    @Test
    fun `로또 번호에 중복 값이 존재하는 경우 예외 테스트`(){
        assertThrows<IllegalArgumentException> {
            lottoValidation.checkAccuracyLottoNumbers("1,2,3,4,5,5")
        }
    }

    @Test
    fun `보너스 넘버가 로또 번호가 아닌 경우 예외 테스트`(){
        assertThrows<IllegalArgumentException> {
            lottoValidation.checkAccuracyBonusNumber("0",setOf(1,2,3,4,5,6))
        }
    }

    @Test
    fun `보너스 넘버가 중복 번호인 경우 예외 테스트`(){
        assertThrows<IllegalArgumentException> {
            lottoValidation.checkAccuracyBonusNumber("1",setOf(1,2,3,4,5,6))
        }
    }
}