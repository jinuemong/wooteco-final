package baseball

import baseball.vaildation.CheckInputValidation
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidationTest {

    private val validation = CheckInputValidation()

    @Test
    fun `올바른 입력 값인 경우 테스트 `() {
        assertThat(validation.checkIsValidNumber("123"))
    }

    @Test
    fun `올바르지 않은 입력 값인 경우 예외 발생 `() {
        assertThrows<IllegalArgumentException> {
            validation.checkIsValidNumber("1234")
        }
    }

    @Test
    fun `올바른 재시작 값인 경우 테스트 `() {
        assertThat(validation.checkRestartNumber("1"))
    }

    @Test
    fun `올바르지 않은 재시작 값인 경우 예외 발생 `() {
        assertThrows<IllegalArgumentException> {
            validation.checkRestartNumber("3")
        }
    }
}