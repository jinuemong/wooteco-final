package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ScoreboardTest {

    private val scoreboard = Scoreboard(
        maxRound = 5,
        processor = Processor(),
        cars = mutableMapOf("ab" to 0, "cd" to 0, "ef" to 0)
    )

    @Test
    fun `정상적인 라운드 증가 테스트`(){
        repeat(5) {
            scoreboard.progressRound()
            assertThat(scoreboard.checkCount())
        }
        // maxRound 도달 시 종료
        assertThrows<IllegalArgumentException> {
            require(scoreboard.checkCount())
        }
    }

    @Test
    fun `우승자 선정 기능 테스트`(){
        assertThat(scoreboard.makeWinningDocument()=="ab, cd, ef")
    }

}