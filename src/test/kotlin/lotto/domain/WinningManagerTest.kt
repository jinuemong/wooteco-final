package lotto.domain

import lotto.domain.model.ResultState
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningManagerTest {

    private val winningManager = WinningManager(
        setOf(1, 2, 3, 4, 5, 6),
        7
    )

    @Test
    fun `로또 결과가 1등 부터 5등까지를 포함하는지 유효성 검사`() {
        val result = winningManager.getLottoResults()
        assertThat(result.size == ResultState.entries.size)
    }

    @Test
    fun `로또 결과지의 초기화 여부 검사`() {
        val result = winningManager.getTotalPrice()
        assertThat(result == 0)
    }

    @Test
    fun `5등 로또 결과 유효성 검사`() {
        winningManager.confirmWinning(setOf(1, 2, 3, 43, 44, 45))
        assertThat(winningManager.getTotalPrice() == ResultState.FIFTH.getPrice(1))
    }

    @Test
    fun `4등 로또 결과 유효성 검사`() {
        winningManager.confirmWinning(setOf(1, 2, 3, 4, 44, 45))
        assertThat(winningManager.getTotalPrice() == ResultState.FOURTH.getPrice(1))
    }

    @Test
    fun `3등 로또 결과 유효성 검사`() {
        winningManager.confirmWinning(setOf(1, 2, 3, 4, 5, 45))
        assertThat(winningManager.getTotalPrice() == ResultState.THIRD.getPrice(1))
    }

    @Test
    fun `2등 로또 결과 유효성 검사`() {
        winningManager.confirmWinning(setOf(1, 2, 3, 4, 5, 7))
        assertThat(winningManager.getTotalPrice() == ResultState.SECOND.getPrice(1))
    }

    @Test
    fun `1등 로또 결과 유효성 검사`() {
        winningManager.confirmWinning(setOf(1, 2, 3, 4, 5, 6))
        assertThat(winningManager.getTotalPrice() == ResultState.FIRST.getPrice(1))
    }

}