package lotto.validation

import lotto.util.Rule
import java.lang.NumberFormatException

class InputValidation {

    private fun checkIsNumber(userInput: String): Boolean {
        return try {
            userInput.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun checkMinimumPrice(price: Int): Boolean{
        return price >= Rule.LOTTO_PRICE
    }

    private fun checkCorrectPrice(price: Int): Boolean{
        return price % Rule.LOTTO_PRICE == 0
    }

}