package baseball.domain

import baseball.util.GameRule
import camp.nextstep.edu.missionutils.Randoms

class Computer(
    private val numbers: MutableList<Int> = mutableListOf()
) {

    init {
        makeNumbers()
    }

    private fun makeNumbers() {
        while (numbers.size < GameRule.NUMBER_SIZE) {
            pickNumber(Randoms.pickNumberInRange(GameRule.MIN_NUMBER, GameRule.MAX_NUMBER))
        }
    }

    private fun pickNumber(newNumber: Int) {
        if (!checkDuplication(newNumber)) numbers.add(newNumber)
    }

    private fun checkDuplication(newNumber: Int): Boolean = numbers.contains(newNumber)

    fun getComputerNumbers(): List<Int> = numbers

}