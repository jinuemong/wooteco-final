package baseball

import baseball.domain.Referee
import baseball.domain.model.ResultState
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultTest {

    private val referee = Referee(listOf(1,2,3))

    @Test
    fun `ball 테스트`(){
        val (state,ball,strike) = referee.checkResult(listOf(3,2,1))
        assertThat(state == ResultState.BALL)
        assertThat(ball == 3)
        assertThat(strike == 0)
    }

    @Test
    fun `strike 테스트`(){
        val (state,ball,strike) = referee.checkResult(listOf(1,2,3))
        assertThat(state == ResultState.STRIKE)
        assertThat(ball == 0)
        assertThat(strike == 3)
    }

    @Test
    fun `strike and ball 테스트`(){
        val (state,ball,strike) = referee.checkResult(listOf(1,3,5))
        assertThat(state == ResultState.STRIKE_AND_BALL)
        assertThat(ball == 1)
        assertThat(strike == 1)
    }

    @Test
    fun `notting 테스트`(){
        val (state,ball,strike) = referee.checkResult(listOf(4,5,6))
        assertThat(state == ResultState.NOTTING)
        assertThat(ball == 0)
        assertThat(strike == 0)
    }
}