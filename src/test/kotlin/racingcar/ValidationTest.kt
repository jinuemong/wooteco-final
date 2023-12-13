package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.validation.InputValidation

class ValidationTest {
    private val validation = InputValidation()

    @Test
    fun `자동차 이름 정확성 테스트`() {
        assertThat(validation.checkAccuracyCarNames("ab,cd,ef"))
    }

    @Test
    fun `자동차 이름 예외 테스트(5글자를 넘는 단어 포함 )`() {
        assertThrows<IllegalArgumentException> {
            validation.checkAccuracyCarNames("ab,cd,efdddd")
        }
    }

    @Test
    fun `자동차 이름 예외 테스트(숫자로만 이루어진 단어 포함)`() {
        assertThrows<IllegalArgumentException> {
            validation.checkAccuracyCarNames("ab,cd,1")
        }
    }

    @Test
    fun `레이싱 넘버 정확성 테스트`() {
        assertThat(validation.checkAccuracyRacingNumber("5"))
    }

    @Test
    fun `레이싱 넘버 예외 테스트(숫자가 아닌 경우) `() {
        assertThrows<IllegalArgumentException> {
            validation.checkAccuracyRacingNumber("오")
        }
    }

    @Test
    fun `레이싱 넘버 예외 테스트(0인 경우) `() {
        assertThrows<IllegalArgumentException> {
            validation.checkAccuracyRacingNumber("0")
        }
    }
}