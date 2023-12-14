package lotto.domain

import lotto.validation.LottoValidation
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoManagerTest {

    private val lottoManager = LottoManager(
        lottoVerifier = LottoValidation(),
        price = 10000
    )

    @Test
    fun `수익률 계산 정확성 테스트`(){
        assertThat(lottoManager.getTotalRate(10000)==100.toDouble())
    }

    @Test
    fun `로또 구매량 정확성 테스트`(){
        assertThat(lottoManager.lottoCount()==10)
    }

}