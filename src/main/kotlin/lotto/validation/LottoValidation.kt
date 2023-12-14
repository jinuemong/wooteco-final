package lotto.validation

import lotto.util.Error
import lotto.util.Form
import lotto.util.Rule
import java.lang.NumberFormatException

class LottoValidation {

    fun checkAccuracyLottoNumbers(input: String) {
        val numbers = input.split(Form.LOTTO_SEPARATOR)
        require(checkLottoCount(numbers)) {
            Error.INCORRECT_LOTTO_COUNT
        }
        numbers.forEach { number ->
            checkAccuracyLottoNumber(number)
        }

        require(checkLottoDuplicate(numbers)) {
            Error.DUPLICATE_NUM
        }
    }

    fun checkAccuracyBonusNumber(input: String, numbers: Set<Int>) {

        require(checkIsNumber(input) && checkIsLottoNum(input.toInt())) {
            Error.INCORRECT_LOTTO_NUM
        }

        require(checkBonusDuplicate(input.toInt(), numbers))
    }

    private fun checkAccuracyLottoNumber(number: String) {
        require(checkIsNumber(number) && checkIsLottoNum(number.toInt())) {
            Error.INCORRECT_LOTTO_NUM
        }
    }

    private fun checkLottoDuplicate(numbers: List<String>): Boolean = numbers.size == numbers.toSet().size

    private fun checkBonusDuplicate(number: Int, numbers: Set<Int>): Boolean = numbers.contains(number)

    private fun checkIsNumber(userInput: String): Boolean {
        return try {
            userInput.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun checkIsLottoNum(num: Int): Boolean {
        return num in Rule.MIN_LOTTO_NUM..Rule.MAX_LOTTO_NUM
    }

    private fun checkLottoCount(numbers: List<String>): Boolean {
        return numbers.size == Rule.LOTTO_COUNT
    }

}