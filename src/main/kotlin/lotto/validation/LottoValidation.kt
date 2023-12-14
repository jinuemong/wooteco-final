package lotto.validation

import lotto.util.Error
import lotto.util.Form
import lotto.util.Rule
import java.lang.NumberFormatException

class LottoValidation {

    fun checkAccuracyLottoNumbers(input: String) {
        val numbers = input.split("${Form.LOTTO_SEPARATOR} ")
        require(checkLottoCount(numbers)) {
            Error.INCORRECT_LOTTO_COUNT
        }
        numbers.forEach { number ->
            checkAccuracyLottoNumber(number)
        }
    }

    fun checkAccuracyBonusNumber(input: String) {

        require(checkIsNumber(input) && checkIsLottoNum(input.toInt())) {
            Error.INCORRECT_LOTTO_NUM
        }
    }

    private fun checkAccuracyLottoNumber(number: String) {
        require(checkIsNumber(number) && checkIsLottoNum(number.toInt())) {
            Error.INCORRECT_LOTTO_NUM
        }
    }

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