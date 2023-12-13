package racingcar.domain

import racingcar.domain.model.CarState
import racingcar.util.Form
import racingcar.util.Rule

class Scoreboard(
    private val processor: Processor,
    private var cars: MutableMap<String, Int> = mutableMapOf(),
    private val maxRound: Int
) {
    private var currentRound = 0

    fun getCarNames() = cars.keys

    fun checkCount(): Boolean = maxRound > currentRound

    fun progressRound() {
        getCarNames().forEach { name ->
            racingCar(name)
        }
        currentRound += 1
    }

    fun getMatchCount(name: String): Int? = cars[name]

    private fun racingCar(name: String) {
        when (processor.getProcess()) {
            CarState.FORWARD -> cars[name] = (cars[name] ?: 0) + Rule.CAR_PROGRESS
            CarState.STOP -> {}
        }
    }

    fun makeWinningDocument(): String = findWinner().joinToString(Form.RESULT_SEPARATOR)

    private fun findWinner(): List<String> {
        val winnerNumber = getFirstCarCount()
        return cars.filterValues { it == winnerNumber }.keys.toList()
    }

    private fun getFirstCarCount() = cars.values.max()

}