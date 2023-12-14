package lotto.domain.model

import lotto.util.Error
import lotto.util.Form

import lotto.util.Rule

class Lotto(
    private val numbers: List<Int>
) {
    init {
        require(numbers.size == Rule.LOTTO_COUNT){
            Error.INCORRECT_LOTTO_COUNT
        }
        require(numbers.toSet().size == Rule.LOTTO_COUNT){
            Error.DUPLICATE_NUM
        }
        require(numbers.all { number ->
            number in Rule.MIN_LOTTO_NUM..
                    Rule.MAX_LOTTO_NUM
        }){
            Error.INCORRECT_LOTTO_NUM
        }
    }

    fun convertOutputValue() =
        numbers.sorted().joinToString("${Form.LOTTO_SEPARATOR} ")

    fun convertSetVale() = numbers.toSet()

}