package baseball.domain

import baseball.util.GameRule
import camp.nextstep.edu.missionutils.Randoms

class Computer(
    private val numbers: MutableList<Int> = mutableListOf()
) {

    fun makeNumbers() {
        numbers.clear()
        while (numbers.size < GameRule.NUMBER_SIZE) {
            pickNumber()
        }
    }

    private fun pickNumber() {
        val newNumber = Randoms.pickNumberInRange(GameRule.MIN_NUMBER, GameRule.MAX_NUMBER)
        if (!checkDuplication(newNumber)) numbers.add(newNumber)
    }

    private fun checkDuplication(newNumber: Int): Boolean = numbers.contains(newNumber)

    fun getComputerNumbers(): List<Int> = numbers

}