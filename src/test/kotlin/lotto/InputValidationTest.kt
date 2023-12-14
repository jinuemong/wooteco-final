package lotto

import lotto.validation.InputValidation
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidationTest {
    private val inputValidation = InputValidation()

    @Test
    fun `사용자 구매 금액의 유효성 검사`() {
        assertThat(inputValidation.checkAccuracyPurchasePrice("1000"))
    }

    @Test
    fun `사용자 구매 금액이 숫자가 아닌 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkAccuracyPurchasePrice("오만")
        }
    }

    @Test
    fun `사용자 구매 금액이 너무 적은 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkAccuracyPurchasePrice("100")
        }
    }


    @Test
    fun `사용자 구매 금액이 정확하지 않은 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            inputValidation.checkAccuracyPurchasePrice("10010")
        }
    }
}