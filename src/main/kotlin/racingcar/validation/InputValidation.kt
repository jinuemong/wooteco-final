package racingcar.validation

import racingcar.util.Form
import racingcar.util.Rule
import java.lang.NumberFormatException

class InputValidation {

    fun checkAccuracyCarNames(userInput: String){
        userInput.split(Form.SEPARATOR).forEach {
            require(isCorrectNameLength(it) && !isNumber(userInput))
        }
    }

    fun checkAccuracyRacingNumber(userInput: String){
        require(isNumber(userInput) && isProgress(userInput.toInt()))
    }


    private fun isNumber(userInput: String): Boolean {
        return try {
            userInput.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    private fun isProgress(userInput: Int): Boolean = userInput >= Rule.MINIMUM_NUMBER


    private fun isCorrectNameLength(name: String): Boolean =
        name.length in Rule.MIN_NAME..Rule.MAX_NAME


}