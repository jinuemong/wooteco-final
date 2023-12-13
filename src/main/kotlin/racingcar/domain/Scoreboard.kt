package racingcar.domain

import racingcar.util.Form
import racingcar.util.Rule


class Scoreboard(
    private val cars: Map<String, Int> = mutableMapOf()
) {

    fun progressCar(names: List<String>) {
        names.forEach { name ->
            cars[name]?.plus(Rule.CAR_PROGRESS)
        }
    }

    fun makeWinningDocument(): String = findWinner().joinToString(Form.RESULT_SEPARATOR)

    private fun findWinner(): List<String> {
        val winnerNumber = getFirstCarCount()
        return cars.filterValues { it == winnerNumber }.keys.toList()
    }

    private fun getFirstCarCount() = cars.values.max()


}