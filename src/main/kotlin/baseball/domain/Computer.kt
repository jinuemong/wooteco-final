package baseball.domain

import camp.nextstep.edu.missionutils.Randoms

class Computer(
    private val numbers: MutableList<Int>
) {

    init {
        makeNumbers()
    }

    private fun makeNumbers() {
        while (numbers.size < 3) {
            pickNumber(Randoms.pickNumberInRange(1, 9))
        }
    }

    private fun pickNumber(newNumber: Int) {
        if (!checkDuplication(newNumber)) numbers.add(newNumber)
    }

    private fun checkDuplication(newNumber: Int): Boolean = numbers.contains(newNumber)

    fun getComputerNumbers(): List<Int> = numbers

}