package lotto.validation

import lotto.util.Rule

class InputValidation {


    private fun checkMinimumPrice(price: Int): Boolean{
        return price >= Rule.LOTTO_PRICE
    }

    private fun checkCorrectPrice(price: Int): Boolean{
        return price % Rule.LOTTO_PRICE == 0
    }

}