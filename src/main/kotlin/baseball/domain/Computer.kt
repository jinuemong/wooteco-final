package baseball.domain

import camp.nextstep.edu.missionutils.Randoms

class Computer(
    private val number: MutableList<Int>
) {

    fun makeNumbers() {
        while (number.size < 3) {
            pickNumber(Randoms.pickNumberInRange(1, 9))
        }
    }

    private fun pickNumber(newNumber: Int) {
        if (!checkDuplication(newNumber)) number.add(newNumber)
    }

    private fun checkDuplication(newNumber: Int): Boolean = number.contains(newNumber)

    fun getComputerNumbers(): List<Int> = number

}