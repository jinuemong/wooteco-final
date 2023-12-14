package lotto.validation

import lotto.util.Error
import lotto.util.Rule
import java.lang.NumberFormatException

class InputValidation {

    fun checkAccuracyPurchasePrice(input: String) {

        require(checkIsNumber(input)) {
            Error.INCORRECT_NUMBER
        }

        require(checkMinimumPrice(input.toInt())) {
            Error.INSUFFICIENT_AMOUNT
        }

        require(checkCorrectPrice(input.toInt())) {
            Error.INCORRECT_AMOUNT
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

    private fun checkMinimumPrice(price: Int): Boolean {
        return price >= Rule.LOTTO_PRICE
    }

    private fun checkCorrectPrice(price: Int): Boolean {
        return price % Rule.LOTTO_PRICE == 0
    }

}